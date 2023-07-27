package com.google.composeintro.ui.home

import androidx.compose.runtime.Composable
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.filters
import com.google.composeintro.model.desserts

@Composable
fun HomeScreen() {
    HomeUi(
        filters = filters,
        picks = desserts.take(5),
        populars = desserts.takeLast(5),
        onDessertClick = { },
    )
}