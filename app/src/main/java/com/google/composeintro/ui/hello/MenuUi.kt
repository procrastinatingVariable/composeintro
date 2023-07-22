package com.google.composeintro.ui.hello

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ComposeIntroTheme

@Composable
fun MenuUi(
    onClickBasicLayout: () -> Unit,
    onClickLazyLayout: () -> Unit,
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onClickBasicLayout) {
                Text("Basic Layout")
            }

            Button(onClick = onClickLazyLayout) {
                Text("Lazy Layout")
            }
        }
    }
}

@Preview
@Composable
fun HelloUIPreview() {
    ComposeIntroTheme {
        MenuUi(
            onClickBasicLayout = {},
            onClickLazyLayout = {},
        )
    }
}