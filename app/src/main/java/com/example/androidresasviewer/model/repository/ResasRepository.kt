package com.example.androidresasviewer.model.repository

interface ResasRepository {
    suspend fun getPrefectureList(): List<PrefectureComposition>
    suspend fun getComposition(prefectureComposition: PrefectureComposition): PrefectureComposition
    suspend fun deleteComposition(prefectureComposition: PrefectureComposition): PrefectureComposition
}