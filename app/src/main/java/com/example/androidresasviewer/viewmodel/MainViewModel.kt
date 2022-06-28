package com.example.androidresasviewer.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidresasviewer.model.repository.CompositionData
import com.example.androidresasviewer.model.repository.PrefectureComposition
import com.example.androidresasviewer.model.repository.ResasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val resasRepository: ResasRepository,
) : ViewModel() {
    val prefectures = mutableStateListOf<PrefectureComposition>()

    private val graphDataIndex = mutableStateListOf<Int>()

    val graphData: List<PrefectureComposition>
        get() = graphDataIndex.filter { !prefectures[it].compositionData.isNullOrEmpty() }.map { prefectures[it] }


    init {
        viewModelScope.launch {
            prefectures.addAll(resasRepository.getPrefectureList())
        }
    }

    fun getPrefectureChecked(prefectureComposition: PrefectureComposition): Boolean =
        prefectureComposition.compositionData != null

    fun onChangeChecked(toChecked: Boolean, index: Int) {
        if (toChecked) {
            if (graphData.size >= 6) return

            graphDataIndex.add(index)
            viewModelScope.launch {
                prefectures[index] = resasRepository.getComposition(prefectures[index])
            }
        } else {
            graphDataIndex.remove(index)
            viewModelScope.launch {
                prefectures[index] = resasRepository.deleteComposition(prefectures[index])
            }
        }
    }
}