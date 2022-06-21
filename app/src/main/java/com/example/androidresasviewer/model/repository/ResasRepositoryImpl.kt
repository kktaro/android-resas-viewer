package com.example.androidresasviewer.model.repository

import com.example.androidresasviewer.model.remote_data_source.Prefecture
import com.example.androidresasviewer.model.remote_data_source.RemoteDataSource
import javax.inject.Inject

class ResasRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : ResasRepository {
    override suspend fun getPrefectureList(): List<PrefectureComposition> {
        return remoteDataSource.getPrefectures().result.map {
            it.toPrefectureComposition()
        }
    }
}

private fun Prefecture.toPrefectureComposition(): PrefectureComposition {
    return PrefectureComposition(
        code = CompositionCode(this.prefectureCode),
        name = CompositionName(this.prefectureName),
        year = null,
        population = null,
    )
}

