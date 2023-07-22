package com.google.composeintro.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.composeintro.ui.lazy.LazyListScreen
import com.google.composeintro.ui.hello.MenuScreen
import com.google.composeintro.ui.basic.BasicLayoutsScreen

@Composable
fun Main() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "hello"
    ) {
        composable("hello") {
            MenuScreen(
                onClickBasicLayout = { navController.navigate("basic") },
                onClickLazyLayout = { navController.navigate("lazy") }
            )
        }

        composable("basic") {
            BasicLayoutsScreen()
        }

        composable("lazy") {
            LazyListScreen()
        }
    }
}

@Preview
@Composable
fun TestPreview() {
    Box {
        Text("Hello World")
    }
}