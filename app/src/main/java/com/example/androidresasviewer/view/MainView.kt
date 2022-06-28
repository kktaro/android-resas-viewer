package com.example.androidresasviewer.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androidresasviewer.settings.Settings.Companion.APP_NAME
import com.example.androidresasviewer.view.component.molecule.LabelledCheckbox
import com.example.androidresasviewer.view.component.organism.PopulationGraph
import com.example.androidresasviewer.viewmodel.MainViewModel

@ExperimentalMaterial3Api
@Composable
fun MainView(viewModel: MainViewModel) {
    Scaffold(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxWidth(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(APP_NAME) },
            )
        },
    ) {
        Box(modifier = Modifier.padding(it))
        {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(112.dp),
                    verticalArrangement = Arrangement.spacedBy(1.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                ) {
                    items(viewModel.prefectures.size) {
                        Row {
                            val target = viewModel.prefectures[it]
                            LabelledCheckbox(
                                checked = viewModel.getPrefectureChecked(target),
                                onCheckedChange = { checked ->
                                    viewModel.onChangeChecked(
                                        checked,
                                        it
                                    )
                                },
                                text = target.name.value,
                            )
                        }
                    }
                }
                PopulationGraph(data = viewModel.graphData)
            }
        }
    }
}

