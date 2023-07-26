package com.google.composeintro.ui.checkout

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.composeintro.model.OrderItem
import com.google.composeintro.model.decrementOrder
import com.google.composeintro.model.desserts
import com.google.composeintro.model.incrementOrder
import com.google.composeintro.model.order
import kotlin.random.Random

@Composable
fun CheckoutUi(
    // Look at OrderItem model/OrderItem.kt and notice how quantityState is a mutableStateOf
    orderItems: List<OrderItem>
) {
    //✏️✏️✏️TODO we need a mutableStateOf here. But of what?
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 8.dp)
    ) {
        //✏️✏️✏️TODO: Add add / remove buttons
        // use getRandomOrderItem() to generate a random order item
        //❗️️️️️️❗️HINT: orderItems is an IMMUTABLE list (there are no add/remove/update methods)
        // in this case a new item can be obtained by creating a NEW LIST with oldList + newItem
        //❗️️️️️️❗️HINT: to remove an item from an immutable list: list.dropLatest(1)

        Order(/* what should we pass here?*/)

        Divider(modifier = Modifier.fillMaxWidth())

        OrderSummary(/* what should we pass here?*/)
    }
}

@Composable
private fun Order(
    /*✏️✏️✏️TODO we need an argument here*/
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        //✏️✏️✏️TODO fill the column with order items
        //❗️️️️️️❗️HINT: use CheckoutItem composable for each item
    }
}

@Composable
private fun OrderSummary(
    /*✏️✏️✏️TODO we need an argument here*/
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            "Summary",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(8.dp))

        SummaryRow("Subtotal", /*computed subtotal value*/)
        SummaryRow("Shipping & Handling", /* computed shipping tax */)
    }
}

@Composable
private fun SummaryRow(
    label: String,
    value: String = "",
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label,
            style = MaterialTheme.typography.labelMedium,
        )
        Text(
            value,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
private fun AddButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Add item")
    }
}

@Composable
private fun RemoveButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Remove item")
    }
}

fun computeSubtotal(orderItems: List<OrderItem>): Float {
    return orderItems.fold(0f) { acc, orderItem ->
        acc + orderItem.dessert.price * orderItem.quantityState.value
    }
}

fun computeShipping(orderItems: List<OrderItem>): Float {
    return computeSubtotal(orderItems) * 0.05f
}

fun getRandomOrderItem(): OrderItem {
    return OrderItem(
        dessert = desserts[Random.nextInt(0, desserts.lastIndex)],
    )
}

@Preview
@Composable
fun CheckoutUiPreview() {
    CheckoutUi(
        order
    )
}