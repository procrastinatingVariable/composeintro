package com.google.composeintro.ui

import android.net.wifi.hotspot2.pps.HomeSp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.composeintro.MainActivity
import com.google.composeintro.model.desserts
import com.google.composeintro.ui.checkout.CheckoutScreen
import com.google.composeintro.ui.lazy.LazyListScreen
import com.google.composeintro.ui.hello.MenuScreen
import com.google.composeintro.ui.home.HomeScreen
import com.google.composeintro.ui.details.DetailsScreen
import com.google.composeintro.ui.profile.ProfileScreen
import com.google.composeintro.ui.search.SearchScreen

private val BottomBarHeight = 42.dp

private enum class BottomBarItem {
    HOME,
    SEARCH,
    CHECKOUT,
    PROFILE
}

@Composable
fun Main() {
    val selectedBottomBarItem = remember { mutableStateOf(BottomBarItem.HOME) }

    Box(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(bottom = BottomBarHeight)
        ) {
            composable("home") {
                //✏️✏️✏️TODO update home screen to handle item clicks and navigate to a dessert page
                //❗️❗️HINT: use string interpolation "details/${...}" or "details/" + id
                // in order to construct the navigation route with arguments

                HomeScreen(
                    onDessertClick = { dessert ->
                        navController.navigate("details/${dessert.id}")
                    }
                )
            }

            composable("search") {
                SearchScreen()
            }

            composable("checkout") {
                CheckoutScreen()
            }

            composable("profile") {
                ProfileScreen()
            }

            //✏️✏️✏️TODO Add details screen destination
            composable(
                route = "details/{id}",
                arguments = listOf(
                    navArgument("id") {
                        type = NavType.LongType
                    }
                )
            ) { backstackEntry ->
                val args = backstackEntry.arguments
                // args can be null so we use the safe call operator
                // this means that if args is null, id will be null as well
                val id = args?.getLong("id")
                // we throw an exception if someone navigated here with a null id as we don't know
                // what to display on the screen
                if (id == null) {
                    throw IllegalArgumentException("ID cannot be null")
                }
                DetailsScreen(
                    id = id,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        BottomNavigationBar(
            selectedItem = selectedBottomBarItem.value,
            onItemSelected = { item ->
                selectedBottomBarItem.value = item
                when (item) {
                    BottomBarItem.HOME -> navController.navigate("home")
                    BottomBarItem.SEARCH -> navController.navigate("search")
                    BottomBarItem.CHECKOUT -> navController.navigate("checkout")
                    BottomBarItem.PROFILE -> navController.navigate("profile")
                }
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun BottomNavigationBar(
    selectedItem: BottomBarItem,
    onItemSelected: (BottomBarItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .height(BottomBarHeight)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomBarItem(
            isSelected = selectedItem == BottomBarItem.HOME,
            Icons.Outlined.Home,
            onClick = {
                onItemSelected(BottomBarItem.HOME)
            }
        )

        BottomBarItem(
            isSelected = selectedItem == BottomBarItem.SEARCH,
            Icons.Outlined.Search,
            onClick = {
                onItemSelected(BottomBarItem.SEARCH)
            }
        )

        BottomBarItem(
            isSelected = selectedItem == BottomBarItem.CHECKOUT,
            Icons.Outlined.ShoppingCart,
            onClick = {
                onItemSelected(BottomBarItem.CHECKOUT)
            }
        )

        BottomBarItem(
            isSelected = selectedItem == BottomBarItem.PROFILE,
            Icons.Outlined.Person,
            onClick = {
                onItemSelected(BottomBarItem.PROFILE)
            }
        )
    }
}

@Composable
private fun BottomBarItem(
    isSelected: Boolean,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val tint = if (isSelected) Color.White else Color.Gray
    Icon(
        modifier = modifier.clickable(onClick = onClick),
        imageVector = icon,
        contentDescription = "bottom bar icon",
        tint = tint,
    )
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        selectedItem = BottomBarItem.HOME,
        onItemSelected = {}
    )
}

@Preview
@Composable
fun MainPreview() {
    Main()
}