package com.example.sync_compose.data.di

import com.example.sync_compose.BuildConfig
import com.example.sync_compose.data.interceptor.AuthAuthenticator
import com.example.sync_compose.data.interceptor.AuthHeaderInterceptor
import com.example.sync_compose.data.source.AuthDataSource
import com.example.sync_compose.datastore.datasource.TokenDataSource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        coerceInputValues = true
        prettyPrint = true
    }

    @Singleton
    @Provides
    fun provideJsonConverterFactory(json: Json): Converter.Factory =
        json.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideHttpClient(
        loggingIntercepter: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingIntercepter)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingIntercepter(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideAuthHeaderInterceptor(
        tokenDataSource: TokenDataSource
    ): Interceptor {
        return AuthHeaderInterceptor(tokenDataSource)
    }

    @Provides
    @Singleton
    fun provideAuthAuthenticator(
        tokenDataSource: TokenDataSource, authDataSource: AuthDataSource
    ): Authenticator {
        return AuthAuthenticator(tokenDataSource, authDataSource)
    }

    @Provides
    @Singleton
    @DefaultOkHttpClient
    fun provideDefaultOkHttpClient(
        logInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(logInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @AuthOkHttpClient
    fun provideAuthOkHttpClient(
        logInterceptor: HttpLoggingInterceptor,
        authInterceptor: Interceptor,
        authenticator: Authenticator
    ): OkHttpClient =
        OkHttpClient.Builder()
            .authenticator(authenticator)
            .addNetworkInterceptor(logInterceptor)
            .addInterceptor(authInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    @DefaultRetrofit
    fun provideDefaultRetrofit(
        @DefaultOkHttpClient okHttpClient: OkHttpClient,
        gsonConverterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @AuthRetrofit
    fun provideAuthRetrofit(
        @AuthOkHttpClient okHttpClient: OkHttpClient,
        gsonConverterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }
}