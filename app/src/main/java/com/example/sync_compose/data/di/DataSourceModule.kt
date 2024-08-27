package com.example.sync_compose.data.di

import com.example.sync_compose.data.source.AuthDataSource
import com.example.sync_compose.data.source.AuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    @Singleton
    fun bindAuthDataSource(dataSourceImpl: AuthDataSourceImpl): AuthDataSource
}