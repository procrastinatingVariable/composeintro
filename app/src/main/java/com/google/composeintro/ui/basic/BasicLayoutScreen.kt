package com.google.composeintro.ui.basic

import androidx.compose.runtime.Composable
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.filters
import com.google.composeintro.model.desserts

@Composable
fun BasicLayoutsScreen(onDessertClick: (Dessert) -> Unit) {
    BasicLayoutsUI(
        filters = filters,
        picks = desserts,
        populars = desserts.takeLast(5),
        onDessertClick = onDessertClick,
    )
}