package com.example.androidresasviewer.model.remote_data_source

import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val client: ResasApiClient,
) : RemoteDataSource {
    override suspend fun getPrefectures(): Prefectures {
        val response = client.getPrefectures()
        if (response.isSuccessful) {
            return response.body() ?: throw ResasException()
        } else {
            throw ResasException()
        }
    }
}

class ResasException: Throwable()