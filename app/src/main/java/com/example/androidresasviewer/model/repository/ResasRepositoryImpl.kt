package com.example.androidresasviewer.model.repository

import com.example.androidresasviewer.model.remote_data_source.Compositions
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

    override suspend fun getComposition(prefectureComposition: PrefectureComposition): PrefectureComposition {
        val compositions = remoteDataSource.getComposition(prefectureComposition.code.value).compositions.data[0]
        return prefectureComposition.copy(
            compositionData = compositions.toCompositionData(),
        )
    }

    override suspend fun deleteComposition(prefectureComposition: PrefectureComposition): PrefectureComposition {
        return prefectureComposition.copy(compositionData = null)
    }
}

private fun Prefecture.toPrefectureComposition(): PrefectureComposition {
    return PrefectureComposition(
        code = CompositionCode(this.prefectureCode),
        name = CompositionName(this.prefectureName),
        compositionData = null,
    )
}

private fun Compositions.toCompositionData(): List<CompositionData> {
    val result = this.data.map {
        CompositionData(
            compositionYear = CompositionYear(it.year),
            compositionPopulation = CompositionPopulation(it.population),
        )
    }
    return result
}

