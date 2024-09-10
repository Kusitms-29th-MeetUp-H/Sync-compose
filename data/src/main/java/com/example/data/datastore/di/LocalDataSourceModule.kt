package com.example.data.datastore.di

import com.example.data.datastore.datasource.TokenDataSource
import com.example.data.datastore.datasource.TokenDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindsTokenDataSource(dataSourceImpl: TokenDataSourceImpl): TokenDataSource
}