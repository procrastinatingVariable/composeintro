package com.google.composeintro.ui.checkout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.composeintro.model.Dessert
import com.google.composeintro.model.OrderItem
import com.google.composeintro.model.desserts
import com.google.composeintro.model.formattedPrice
import com.google.composeintro.ui.common.Minus
import com.google.composeintro.ui.common.UrlImage

@Composable
fun CheckoutItem(
    orderItem: OrderItem,
    onQuantityDecrease: () -> Unit,
    onQuantityIncrease: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        UrlImage(
            orderItem.dessert.imageUrl,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp)
        )

        Spacer(Modifier.width(8.dp))

        Column {
            Texts(orderItem.dessert)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Price(orderItem.dessert.formattedPrice)

                Quantity(
                    orderItem.quantity,
                    onQuantityDecrease = onQuantityDecrease,
                    onQuantityIncrease = onQuantityIncrease,
                )
            }
        }
    }
}

@Composable
private fun Texts(dessert: Dessert) {
    Text(dessert.name, style = MaterialTheme.typography.titleMedium)
    Text(dessert.tagline, style = MaterialTheme.typography.labelMedium)
}

@Composable
private fun Price(
    price: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = price,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier,
    )
}


@Composable
private fun Quantity(
    quantity: Int,
    onQuantityIncrease: () -> Unit,
    onQuantityDecrease: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        QuantityLabel()
        Spacer(Modifier.width(4.dp))
        QuantityChangeButton(icon = Icons.Default.Minus, onClick = { onQuantityDecrease() })
        QuantityText(quantity, modifier = Modifier.padding(horizontal = 4.dp))
        QuantityChangeButton(icon = Icons.Default.Add, onClick = { onQuantityIncrease() })
    }
}


@Composable
private fun QuantityText(
    count: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = count.toString(),
        style = MaterialTheme.typography.labelLarge,
        modifier = modifier.padding(horizontal = 8.dp)
    )
}


@Composable
private fun QuantityLabel() {
    Text(
        "Qty",
        style = MaterialTheme.typography.labelLarge
    )
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
fun CheckoutItemPreview() {
    CheckoutItem(
        orderItem = OrderItem(desserts.first(), 2),
        onQuantityDecrease = {},
        onQuantityIncrease = {},
    )
}