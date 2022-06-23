package com.example.androidresasviewer.viewmodel

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
//            prefectures.addAll(resasRepository.getPrefectureList())
        }
    }

    fun onUpdatePrefecture() {
        viewModelScope.launch {
            prefectures.addAll(resasRepository.getPrefectureList())
        }
    }
}