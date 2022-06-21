package com.example.androidresasviewer.model.repository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ResasRepositoryModule {
    @Provides
    fun provideResasRepository(resasRepositoryImpl: ResasRepositoryImpl): ResasRepository =
        resasRepositoryImpl
}