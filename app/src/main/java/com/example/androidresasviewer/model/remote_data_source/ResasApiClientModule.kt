package com.example.androidresasviewer.model.remote_data_source

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ResasApiClientModule {
    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideResasApiClient(provider: ResasApiClientProvider): ResasApiClient =
        provider.provide()
}