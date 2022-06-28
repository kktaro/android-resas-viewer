package com.example.androidresasviewer.view.component.organism

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.androidresasviewer.model.repository.*
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

private val GRAPH_COLOR = listOf(
    Color(0xFFFF4B00).toArgb(),
    Color(0xFF005AFF).toArgb(),
    Color(0xFF03AF7A).toArgb(),
    Color(0xFF4DC4FF).toArgb(),
    Color(0xFFF6AA00).toArgb(),
    Color(0xFFFFF100).toArgb(),
)


@Composable
fun PopulationGraph(
    data: List<PrefectureComposition>,
) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val lineChart = LineChart(context).apply {
                this.legend.form = Legend.LegendForm.LINE
                this.setTouchEnabled(false)
                this.axisRight.isEnabled = false
            }
            lineChart
        },
        update = { lineChart ->
            val lineDataSets = data.mapIndexed{ index, prefecture ->
                LineDataSet(
                    prefecture.compositionData!!.map {
                        Entry(
                            it.compositionYear.value.toFloat(),
                            it.compositionPopulation.value.toFloat(),
                        )
                    },
                    prefecture.name.value,
                ).apply {
                    this.color = GRAPH_COLOR[index]
                    this.setDrawValues(false)
                    this.lineWidth = 2f
                }
            }
            val lineData = LineData(lineDataSets)
            lineChart.data = lineData

            lineChart.invalidate()
        }
    )
}

@Preview
@Composable
private fun PopulationGraphPreview() {
    val testData = listOf(
        PrefectureComposition(
            code = CompositionCode(1),
            name = CompositionName("北海道"),
            compositionData = listOf(
                CompositionData(
                    compositionYear = CompositionYear(1960),
                    compositionPopulation = CompositionPopulation(5039206)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1965),
                    compositionPopulation = CompositionPopulation(5171800)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1970),
                    compositionPopulation = CompositionPopulation(5184287)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1975),
                    compositionPopulation = CompositionPopulation(5338206)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1980),
                    compositionPopulation = CompositionPopulation(5575989)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1985),
                    compositionPopulation = CompositionPopulation(5679439)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1990),
                    compositionPopulation = CompositionPopulation(5643647)
                ),
                CompositionData(
                    compositionYear = CompositionYear(1995),
                    compositionPopulation = CompositionPopulation(5692321)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2000),
                    compositionPopulation = CompositionPopulation(5683062)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2005),
                    compositionPopulation = CompositionPopulation(5627737)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2010),
                    compositionPopulation = CompositionPopulation(5506419)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2015),
                    compositionPopulation = CompositionPopulation(5381733)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2020),
                    compositionPopulation = CompositionPopulation(5216615)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2025),
                    compositionPopulation = CompositionPopulation(5016554)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2030),
                    compositionPopulation = CompositionPopulation(4791592)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2035),
                    compositionPopulation = CompositionPopulation(4546357)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2040),
                    compositionPopulation = CompositionPopulation(4280427)
                ),
                CompositionData(
                    compositionYear = CompositionYear(2045),
                    compositionPopulation = CompositionPopulation(4004973)
                ),
            )
        ),
        PrefectureComposition(
            code = CompositionCode(2),
            name = CompositionName("青森県"),
            compositionData = listOf(
            CompositionData(
                compositionYear = CompositionYear(1960),
                compositionPopulation = CompositionPopulation(1426606)
            ),
            CompositionData(
                compositionYear = CompositionYear(1965),
                compositionPopulation = CompositionPopulation(1416591)
            ),
            CompositionData(
                compositionYear = CompositionYear(1970),
                compositionPopulation = CompositionPopulation(1427520)
            ),
            CompositionData(
                compositionYear = CompositionYear(1975),
                compositionPopulation = CompositionPopulation(1468646)
            ),
            CompositionData(
                compositionYear = CompositionYear(1980),
                compositionPopulation = CompositionPopulation(1523907)
            ),
            CompositionData(
                compositionYear = CompositionYear(1985),
                compositionPopulation = CompositionPopulation(1524448)
            ),
            CompositionData(
                compositionYear = CompositionYear(1990),
                compositionPopulation = CompositionPopulation(1482873)
            ),
            CompositionData(
                compositionYear = CompositionYear(1995),
                compositionPopulation = CompositionPopulation(1481663)
            ),
            CompositionData(
                compositionYear = CompositionYear(2000),
                compositionPopulation = CompositionPopulation(1475728)
            ),
            CompositionData(
                compositionYear = CompositionYear(2005),
                compositionPopulation = CompositionPopulation(1436657)
            ),
            CompositionData(
                compositionYear = CompositionYear(2010),
                compositionPopulation = CompositionPopulation(1373339)
            ),
            CompositionData(
                compositionYear = CompositionYear(2015),
                compositionPopulation = CompositionPopulation(1308265)
            ),
            CompositionData(
                compositionYear = CompositionYear(2020),
                compositionPopulation = CompositionPopulation(1235971)
            ),
            CompositionData(
                compositionYear = CompositionYear(2025),
                compositionPopulation = CompositionPopulation(1157332)
            ),
            CompositionData(
                compositionYear = CompositionYear(2030),
                compositionPopulation = CompositionPopulation(1076393)
            ),
            CompositionData(
                compositionYear = CompositionYear(2035),
                compositionPopulation = CompositionPopulation(993737)
            ),
            CompositionData(
                compositionYear = CompositionYear(2040),
                compositionPopulation = CompositionPopulation(908974)
            ),
            CompositionData(
                compositionYear = CompositionYear(2045),
                compositionPopulation = CompositionPopulation(823610)
            ),
        ),
        ),
    )

    PopulationGraph(data = testData)
}