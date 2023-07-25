package com.google.composeintro.model

data class OrderItem(
    val dessert: Dessert,
    val quantity: Int,
)

fun OrderItem.incrementOrder(): OrderItem {
    return copy(quantity = quantity + 1)
}

fun OrderItem.decrementOrder(): OrderItem {
    return copy(quantity = quantity - 1)
}

val order = desserts.take(3).map {
    OrderItem(it, 1)
}