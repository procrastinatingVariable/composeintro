package com.google.composeintro.ui.details

import androidx.compose.runtime.Composable
import com.google.composeintro.model.Dessert

@Composable
fun DetailsScreen(dessert: Dessert, onBackClick: () -> Unit) {
    DetailsUi(
        dessert,
        1,
        onIncrementQuantity = {},
        onDecrementQuantity = {},
        onAddToCartClick = {},
        onBackClick = onBackClick,
    )
}