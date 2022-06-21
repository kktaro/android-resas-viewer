package com.example.androidresasviewer.model.repository

data class PrefectureComposition(
    val code: CompositionCode,
    val name: CompositionName,
    val year: CompositionYear?,
    val population: CompositionPopulation?,
)

@JvmInline
value class CompositionCode(val value: Int)

@JvmInline
value class CompositionName(val value: String)

@JvmInline
value class CompositionYear(val value: Int)

@JvmInline
value class CompositionPopulation(val value: Int)
