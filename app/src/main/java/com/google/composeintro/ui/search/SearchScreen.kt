package com.google.composeintro.ui.search

import androidx.compose.runtime.Composable
import com.google.composeintro.model.desserts

@Composable
fun SearchScreen() {
    SearchUi(desserts)
}