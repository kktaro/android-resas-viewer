package com.example.androidresasviewer.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prefectures(
    @SerialName("result") val result: List<Prefecture>,
)

@Serializable
data class Prefecture(
    @SerialName("prefCode") val prefectureCode: Int,
    @SerialName("prefName") val prefectureName: String,
)
