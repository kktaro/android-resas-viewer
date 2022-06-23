package com.example.androidresasviewer.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.androidresasviewer.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(viewModel: MainViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {viewModel.onUpdatePrefecture()}
            ) {
            }
        }
    ) {
        Column(
            Modifier.fillMaxWidth()
        ) {
            if (!viewModel.prefectures.isEmpty()) {
                viewModel.prefectures.map {
                    Row {
                        Text(text = it.code.value.toString())
                        PaddingValues(vertical = Dp(4f))
                        Text(text = it.name.value)
                    }
                }
            }
        }    
        
    }    
}