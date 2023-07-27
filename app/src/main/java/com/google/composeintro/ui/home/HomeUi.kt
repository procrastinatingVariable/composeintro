package com.google.composeintro.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ComposeIntroTheme
import com.google.composeintro.R
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.Filter
import com.google.composeintro.model.desserts
import com.google.composeintro.model.filters
import com.google.composeintro.ui.common.UrlImage

private val imageSize = 96.dp

@Composable
fun HomeUi(
    filters: List<Filter>,
    picks: List<Dessert>,
    populars: List<Dessert>,
    onDessertClick: (Dessert) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Filters(filters)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Android's picks",
                style = MaterialTheme.typography.titleLarge,
            )

            Picks(picks, onDessertClick)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(start = 24.dp),
                text = "Popular on Jetsnack",
                style = MaterialTheme.typography.titleLarge,
            )

            Populars(populars, onDessertClick)
        }

    }
}

@Composable
private fun Filters(
    filters: List<Filter>,
    modifier: Modifier = Modifier
) {
    val state = rememberScrollState()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(state)
            .padding(24.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        filters.forEach { filter ->
            FilterButton(filter)
        }
    }
}

@Composable
private fun FilterButton(
    filter: Filter,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val shape = RoundedCornerShape(16.dp)
    Box(modifier = modifier
        .border(
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.outline),
            shape = shape
        )
        .shadow(2.dp, clip = true, shape = shape)
        .background(color = Color.White)
        .clickable {
            onClick()
        }
        .padding(horizontal = 16.dp, vertical = 6.dp)) {
        Text(
            text = filter.label,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
private fun Picks(
    picks: List<Dessert>,
    onDessertClick: (Dessert) -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberScrollState()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(state)
            .padding(24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        picks.forEach { dessert ->
            PickDessertItem(
                dessert,
                modifier = Modifier.clickable {
                    onDessertClick(dessert)
                }
            )
        }
    }
}

@Composable
fun PickDessertItem(
    dessert: Dessert,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(200.dp)
            .width(148.dp)
            .shadow(4.dp, clip = true, shape = RoundedCornerShape(16.dp))
            .background(shape = RoundedCornerShape(16.dp), color = Color.White)
    ) {

        Box(
            modifier = Modifier
                .weight(0.75f)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        Box(
            modifier = Modifier
                .weight(1.0f)
                .fillMaxWidth(),
        ) {
            DessertImage(
                dessert = dessert,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = -imageSize / 2)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp, bottom = 16.dp)
                    .align(Alignment.BottomStart),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = dessert.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight(600)
                )
                Text(
                    text = dessert.tagline,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
private fun Populars(
    populars: List<Dessert>,
    onDessertClick: (Dessert) -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberScrollState()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(state)
            .padding(24.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        populars.forEach { dessert ->
            PopularDessertItem(
                dessert,
                modifier = Modifier.clickable {
                    onDessertClick(dessert)
                }
            )
        }
    }
}

@Composable
private fun PopularDessertItem(
    dessert: Dessert,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DessertImage(dessert)

        Text(
            text = dessert.name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight(600)
        )

    }
}

@Composable
private fun DessertImage(
    dessert: Dessert,
    modifier: Modifier = Modifier
) {
    UrlImage(
        modifier = modifier
            .size(imageSize)
            .clip(CircleShape),
        url = dessert.imageUrl,
        placeholder = painterResource(R.drawable.placeholder),
        contentDescription = "pick dessert",
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun HomeUiPreview() {
    ComposeIntroTheme {
        HomeUi(
            filters = filters,
            picks = desserts.take(5),
            populars = desserts.takeLast(5),
            onDessertClick = { }
        )
    }
}