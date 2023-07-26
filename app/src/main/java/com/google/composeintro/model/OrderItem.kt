package com.google.composeintro.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class OrderItem(
    val dessert: Dessert,
    var quantityState: MutableState<Int> = mutableStateOf(0),
) {
    constructor(
        dessert: Dessert,
        initialQuantity: Int
    ) : this(
        dessert,
        mutableStateOf(initialQuantity)
    )
}

fun OrderItem.incrementOrder() {
    quantityState.value++
}

fun OrderItem.decrementOrder() {
    quantityState.value--
}

val order = desserts.take(3).map {
    OrderItem(it, 1)
}