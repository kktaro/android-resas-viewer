package com.example.androidresasviewer.model.repository

data class PrefectureComposition(
    val code: CompositionCode,
    val name: CompositionName,
    val compositionData: List<CompositionData>?
)

@JvmInline
value class CompositionCode(val value: Int)

@JvmInline
value class CompositionName(val value: String)

data class CompositionData(
    val compositionYear: CompositionYear,
    val compositionPopulation: CompositionPopulation,
)

@JvmInline
value class CompositionYear(val value: Int)

@JvmInline
value class CompositionPopulation(val value: Int)
