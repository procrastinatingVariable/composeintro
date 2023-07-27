package com.google.composeintro.ui.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ComposeIntroTheme
import com.google.composeintro.R
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.description
import com.google.composeintro.model.desserts
import com.google.composeintro.ui.common.Minus
import com.google.composeintro.ui.common.UrlImage

@Composable
fun DetailsUi(
    dessert: Dessert,
    quantity: Int,
    onIncrementQuantity: () -> Unit,
    onDecrementQuantity: () -> Unit,
    onAddToCartClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Content(
            dessert = dessert,
            onBackClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        AddToCartBar(
            quantity = quantity,
            onIncrement = onIncrementQuantity,
            onDecrement = onDecrementQuantity,
            onAddToCartClick = onAddToCartClick,
        )
    }
}

@Composable
private fun Content(
    dessert: Dessert,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.verticalScroll(rememberScrollState())) {
        Column {
            Header(dessert)

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Description(dessert)
        }

        BackButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(8.dp, 8.dp)
        )
    }
}

private val HeaderBackdropHeight = 120.dp

@Composable
private fun Header(
    dessert: Dessert,
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxWidth()) {
        // colored top-half backdrop
        val backdropHeight = maxWidth * 0.5f
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(backdropHeight)
                .background(MaterialTheme.colorScheme.tertiary)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = backdropHeight / 2)
                .padding(horizontal = 8.dp)
        ) {
            UrlImage(
                url = dessert.imageUrl,
                placeholder = painterResource(R.drawable.placeholder),
                contentDescription = "dessert image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxWidth(0.7f)
                    .aspectRatio(1f)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                dessert.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                dessert.tagline,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
private fun Description(
    dessert: Dessert,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            "Details",
            style = MaterialTheme.typography.bodyMedium,
        )

        Spacer(Modifier.height(12.dp))

        Text(
            dessert.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        Icons.Default.ArrowBack,
        contentDescription = "back",
        tint = MaterialTheme.colorScheme.onTertiary,
        modifier = modifier.clickable(onClick = onClick)
    )
}

@Composable
private fun AddToCartBar(
    quantity: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onAddToCartClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(8.dp),
    ) {
        Text(
            text = "Qty",
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.width(8.dp))

        QuantitySelector(
            quantity = quantity,
            onIncrement = onIncrement,
            onDecrement = onDecrement,
        )

        Spacer(modifier = Modifier.width(8.dp))

        AddToCartButton(
            onClick = onAddToCartClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun QuantitySelector(
    quantity: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        QuantityChangeButton(
            icon = Icons.Default.Minus,
            onClick = onDecrement
        )

        Text(
            quantity.toString(),
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        QuantityChangeButton(
            icon = Icons.Default.Add,
            onClick = onIncrement
        )
    }
}

@Composable
private fun AddToCartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        modifier = modifier,
    ) {
        Text("ADD TO CART")
    }
}

@Composable
private fun QuantityChangeButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Icon(
        imageVector = icon,
        contentDescription = "increment/decrement",
        modifier = modifier
            .border(
                BorderStroke(2.dp, MaterialTheme.colorScheme.primary), shape = CircleShape
            )
            .clip(shape = CircleShape)
            .clickable(onClick = onClick)
    )
}

@Preview
@Composable
private fun DetailsUiPreview() {
    ComposeIntroTheme {
        DetailsUi(
            dessert = desserts.first(),
            quantity = 1,
            onIncrementQuantity = { /*TODO*/ },
            onDecrementQuantity = { /*TODO*/ },
            onAddToCartClick = { },
            onBackClick = {}
        )
    }
}