package com.example.androidresasviewer.model.remote_data_source

import com.example.androidresasviewer.BuildConfig
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ResasApiClient {
    @Headers("x-api-key: ${BuildConfig.RESAS_API_KEY}")
    @GET("api/v1/prefectures")
    suspend fun getPrefectures(): Response<Prefectures>

    @Headers("x-api-key: ${BuildConfig.RESAS_API_KEY}")
    @GET("api/v1/population/composition/perYear?cityCode=-")
    suspend fun getComposition(@Query("prefCode") prefectureCode: Int): Response<CompositionResult>
}