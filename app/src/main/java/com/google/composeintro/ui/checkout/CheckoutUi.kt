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
import com.google.composeintro.model.incrementOrder
import com.google.composeintro.model.order

@Composable
fun CheckoutUi(
    orderItems: List<OrderItem>
) {
    val stateOrderItems = remember {
        val stateList = mutableStateListOf<OrderItem>()
        stateList.addAll(orderItems)
        return@remember stateList
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 8.dp)
    ) {
        Order(
            stateOrderItems,
            onDecreaseOrderFor = { index ->
                stateOrderItems[index] = stateOrderItems[index].decrementOrder()
            },
            onIncreaseOrderFor = { index ->
                stateOrderItems[index] = stateOrderItems[index].incrementOrder()
            }
        )

        Divider(modifier = Modifier.fillMaxWidth())

        OrderSummary(stateOrderItems)
    }
}

@Composable
private fun Order(
    orderItems: List<OrderItem>,
    onIncreaseOrderFor: (Int) -> Unit,
    onDecreaseOrderFor: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(orderItems) { index, item ->
            CheckoutItem(
                item,
                onQuantityDecrease = {
                    onDecreaseOrderFor(index)
                },
                onQuantityIncrease = {
                    onIncreaseOrderFor(index)
                }
            )
        }
    }
}

@Composable
private fun OrderSummary(
    orderItems: List<OrderItem>,
    modifier: Modifier = Modifier,
) {
    val subtotal = computeSubtotal(orderItems)
    val shipping = computeShipping(orderItems)
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            "Summary",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(8.dp))

        SummaryRow("Subtotal", subtotal.toString())
        SummaryRow("Shipping & Handling", shipping.toString())
    }
}

@Composable
private fun SummaryRow(
    label: String,
    value: String,
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

fun computeSubtotal(orderItems: List<OrderItem>): Float {
    return orderItems.fold(0f) { acc, orderItem ->
        acc + orderItem.dessert.price * orderItem.quantity
    }
}

fun computeShipping(orderItems: List<OrderItem>): Float {
    return computeSubtotal(orderItems) * 0.05f
}

@Preview
@Composable
fun CheckoutUiPreview() {
    CheckoutUi(
        order
    )
}