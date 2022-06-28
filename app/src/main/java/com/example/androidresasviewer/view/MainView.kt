package com.example.androidresasviewer.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androidresasviewer.model.repository.ResasRepositoryImpl
import com.example.androidresasviewer.model.repository.ResasRepositoryModule
import com.example.androidresasviewer.view.component.molecule.LabelledCheckbox
import com.example.androidresasviewer.view.component.organism.PopulationGraph
import com.example.androidresasviewer.viewmodel.MainViewModel
import java.util.*

@ExperimentalMaterial3Api
@Composable
fun MainView(viewModel: MainViewModel) {
    Scaffold(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxWidth(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("APP") },
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

