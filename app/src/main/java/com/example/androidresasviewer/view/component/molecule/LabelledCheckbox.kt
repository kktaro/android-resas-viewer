package com.example.androidresasviewer.view.component.molecule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterial3Api
@Composable
fun LabelledCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(22.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChange(it) }
        )
        Text(text = text)
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
private fun PreviewLabelledCheckbox() {
    val checkedState = remember { mutableStateOf(false)}
    LabelledCheckbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it },
        text = "Test Text"
    )
}