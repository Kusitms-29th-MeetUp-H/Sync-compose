package com.example.sync_compose.data.di

import com.example.sync_compose.data.repository.AuthRepository
import com.example.sync_compose.data.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesAuthRepository(repositoryImpl: AuthRepositoryImpl): AuthRepository

}