package com.google.composeintro.ui.basic

import androidx.compose.runtime.Composable
import com.google.composeintro.model.filters
import com.google.composeintro.model.desserts

@Composable
fun BasicLayoutsScreen() {
    BasicLayoutsUI(
        filters = filters,
        picks = desserts.take(5),
        populars = desserts.takeLast(5)
    )
}