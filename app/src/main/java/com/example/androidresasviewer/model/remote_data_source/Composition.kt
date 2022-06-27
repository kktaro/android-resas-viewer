package com.example.androidresasviewer.model.remote_data_source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompositionResult(
    @SerialName("result") val compositions: Boundary,
)

@Serializable
data class Boundary(
    @SerialName("data")val data: List<Compositions>,
)

@Serializable
data class Compositions(
    @SerialName("label") val label: String,
    @SerialName("data") val data: List<Composition>,
)

@Serializable
data class Composition(
    @SerialName("year") val year: Int,
    @SerialName("value") val population: Int,
)
