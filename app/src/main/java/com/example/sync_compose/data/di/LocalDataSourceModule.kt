package com.example.sync_compose.data.di

import com.example.sync_compose.datastore.datasource.TokenDataSource
import com.example.sync_compose.datastore.datasource.TokenDataSourceImpl
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