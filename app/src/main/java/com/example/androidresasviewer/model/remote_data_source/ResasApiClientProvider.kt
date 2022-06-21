package com.example.androidresasviewer.model.remote_data_source

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject

class ResasApiClientProvider @Inject constructor() {
    companion object {
        private const val API_END_POINT = "https://opendata.resas-portal.go.jp/"
    }

    @ExperimentalSerializationApi
    fun provide(): ResasApiClient {
        val format = Json{ignoreUnknownKeys = true}
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                format.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
            .create(ResasApiClient::class.java)
    }
}