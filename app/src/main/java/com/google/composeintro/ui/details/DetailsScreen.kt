package com.google.composeintro.ui.details

import androidx.compose.runtime.Composable
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.desserts

@Composable
fun DetailsScreen(id: Long, onBackClick: () -> Unit) {
    DetailsUi(
        desserts.first { dessert -> dessert.id == id },
        1,
        onIncrementQuantity = {},
        onDecrementQuantity = {},
        onAddToCartClick = {},
        onBackClick = onBackClick,
    )
}