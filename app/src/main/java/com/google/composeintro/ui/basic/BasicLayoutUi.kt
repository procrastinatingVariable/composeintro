package com.google.composeintro.ui.basic

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ComposeIntroTheme
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.Filter
import com.google.composeintro.model.desserts
import com.google.composeintro.model.filters

@Composable
fun BasicLayoutsUI(
    filters: List<Filter>,
    picks: List<Dessert>,
    populars: List<Dessert>,
    onDessertClick: (Dessert) -> Unit,
) {

}

@Preview
@Composable
fun BasicLayoutsUIPreview() {
    ComposeIntroTheme {
        BasicLayoutsUI(
            filters = filters,
            picks = desserts.take(5),
            populars = desserts.takeLast(5),
            onDessertClick = { }
        )
    }
}