package com.example.androidresasviewer.model.repository

interface ResasRepository {
    suspend fun getPrefectureList(): List<PrefectureComposition>
}