package com.example.androidresasviewer.model.remote_data_source

interface RemoteDataSource {
    suspend fun getPrefectures(): Prefectures
}