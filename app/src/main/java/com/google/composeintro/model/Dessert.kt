package com.google.composeintro.model

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

data class Dessert(
    val id: Long,
    val imageUrl: String,
    val name: String,
    val tagline: String = "",
)

val Dessert.description: String
    get() = LoremIpsum(30).values.joinToString()

val desserts = listOf(
    Dessert(
        id = 1L,
        name = "Cupcake",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/pGM4sjt_BdQ",
    ),
    Dessert(
        id = 2L,
        name = "Donut",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/Yc5sL-ejk6U",
    ),
    Dessert(
        id = 3L,
        name = "Eclair",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/-LojFX9NfPY",
    ),
    Dessert(
        id = 4L,
        name = "Froyo",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/3U2V5WqK1PQ",
    ),
    Dessert(
        id = 5L,
        name = "Gingerbread",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/Y4YR9OjdIMk",
    ),
    Dessert(
        id = 6L,
        name = "Honeycomb",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/bELvIg_KZGU",
    ),
    Dessert(
        id = 7L,
        name = "Ice Cream Sandwich",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/YgYJsFDd4AU",
    ),
    Dessert(
        id = 8L,
        name = "Jellybean",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/0u_vbeOkMpk",
    ),
    Dessert(
        id = 9L,
        name = "KitKat",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/yb16pT5F_jE",
    ),
    Dessert(
        id = 10L,
        name = "Lollipop",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/AHF_ZktTL6Q",
    ),
    Dessert(
        id = 11L,
        name = "Marshmallow",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/rqFm0IgMVYY",
    ),
    Dessert(
        id = 12L,
        name = "Nougat",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/qRE_OpbVPR8",
    ),
    Dessert(
        id = 13L,
        name = "Oreo",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/33fWPnyN6tU",
    ),
    Dessert(
        id = 14L,
        name = "Pie",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/aX_ljOOyWJY",
    ),
    Dessert(
        id = 15L,
        name = "Chips",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
    ),
    Dessert(
        id = 16L,
        name = "Pretzels",
        imageUrl = "https://source.unsplash.com/7meCnGCJ5Ms",
    ),
    Dessert(
        id = 17L,
        name = "Smoothies",
        imageUrl = "https://source.unsplash.com/m741tj4Cz7M",
    ),
    Dessert(
        id = 18L,
        name = "Popcorn",
        imageUrl = "https://source.unsplash.com/iuwMdNq0-s4",
    ),
    Dessert(
        id = 19L,
        name = "Almonds",
        imageUrl = "https://source.unsplash.com/qgWWQU1SzqM",
    ),
    Dessert(
        id = 20L,
        name = "Cheese",
        imageUrl = "https://source.unsplash.com/9MzCd76xLGk",
    ),
    Dessert(
        id = 21L,
        name = "Apples",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/1d9xXWMtQzQ",
    ),
    Dessert(
        id = 22L,
        name = "Apple sauce",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/wZxpOw84QTU",
    ),
    Dessert(
        id = 23L,
        name = "Apple chips",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/okzeRxm_GPo",
    ),
    Dessert(
        id = 24L,
        name = "Apple juice",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/l7imGdupuhU",
    ),
    Dessert(
        id = 25L,
        name = "Apple pie",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/bkXzABDt08Q",
    ),
    Dessert(
        id = 26L,
        name = "Grapes",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/y2MeW00BdBo",
    ),
    Dessert(
        id = 27L,
        name = "Kiwi",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/1oMGgHn-M8k",
    ),
    Dessert(
        id = 28L,
        name = "Mango",
        tagline = "A tag line",
        imageUrl = "https://source.unsplash.com/TIGDsyy0TK4",
    )
)
