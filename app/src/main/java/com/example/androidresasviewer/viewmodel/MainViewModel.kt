package com.example.androidresasviewer.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    init {
        viewModelScope.launch {
            prefectures.addAll(resasRepository.getPrefectureList())
        }
    }

    fun getPrefectureChecked(prefectureComposition: PrefectureComposition): Boolean =
        prefectureComposition.compositionData != null

    fun onChangeChecked(toChecked: Boolean, index: Int) {
        if (toChecked) {
            viewModelScope.launch {
                prefectures[index] = resasRepository.getComposition(prefectures[index])
            }
        } else {
            viewModelScope.launch {
                prefectures[index] = resasRepository.deleteComposition(prefectures[index])
            }
        }
        Log.d("北海道", prefectures[index].toString())
    }
}