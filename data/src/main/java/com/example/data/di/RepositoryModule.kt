package com.example.data.di

import com.example.domain.repository.AuthRepository
import com.example.data.repository.AuthRepositoryImpl
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