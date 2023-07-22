package com.google.composeintro.ui.hello

import androidx.compose.runtime.Composable

@Composable
fun MenuScreen(
    onClickBasicLayout: () -> Unit,
    onClickLazyLayout: () -> Unit
) {
    MenuUi(
        onClickBasicLayout = onClickBasicLayout,
        onClickLazyLayout = onClickLazyLayout,
    )
}