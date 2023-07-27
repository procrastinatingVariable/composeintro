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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

@Composable
fun Main() {
    //✏️✏️✏️TODO add some state to track the currently selected bottom bar item
    Box(modifier = Modifier.fillMaxSize()) {
        //✏️✏️✏️TODO add a navigation graph here for HomeScreen, SearchScreen, CheckoutScreen and ProfileScreen

        //✏️✏️✏️TODO update this to handle bar item selection and state change
        BottomNavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun BottomNavigationBar(
    modifier: Modifier = Modifier
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
            //✏️✏️✏️ TODO update this to reflect current selection
            isSelected = false,
            Icons.Outlined.Home,
            onClick = {
                //✏️✏️✏️TODO navigate and update selection
            }
        )

        BottomBarItem(
            //✏️✏️✏️ TODO update this to reflect current selection
            isSelected = false,
            Icons.Outlined.Search,
            onClick = {
                //✏️✏️✏️TODO navigate and update selection
            }
        )

        BottomBarItem(
            //✏️✏️✏️ TODO update this to reflect current selection
            isSelected = false,
            Icons.Outlined.ShoppingCart,
            onClick = {
                //✏️✏️✏️TODO navigate and update selection
            }
        )

        BottomBarItem(
            //✏️✏️✏️ TODO update this to reflect current selection
            isSelected = false,
            Icons.Outlined.Person,
            onClick = {
                //✏️✏️✏️TODO navigate and update selection
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
    BottomNavigationBar()
}

@Preview
@Composable
fun MainPreview() {
    Main()
}