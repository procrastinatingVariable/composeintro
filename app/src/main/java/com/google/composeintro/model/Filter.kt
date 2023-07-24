package com.google.composeintro.model

data class Filter(
    val id: Long,
    val label: String,
)

val filters = listOf(
    Filter(id = 0L, label = "Organic"),
    Filter(id = 1L, label = "Gluten-free"),
    Filter(id = 2L, label = "Dairy-free"),
    Filter(id = 3L, label = "Sweet"),
    Filter(id = 4L, label = "Savory")
)
