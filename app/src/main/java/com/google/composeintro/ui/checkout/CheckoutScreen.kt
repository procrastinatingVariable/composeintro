package com.google.composeintro.ui.checkout

import androidx.compose.runtime.Composable
import com.google.composeintro.model.order

@Composable
fun CheckoutScreen() {
    CheckoutUi(
        orderItems = order
    )
}