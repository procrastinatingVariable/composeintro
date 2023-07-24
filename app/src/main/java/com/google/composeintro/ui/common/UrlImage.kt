package com.google.composeintro.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.composeintro.R


@Composable
fun UrlImage(
    url: String,
    placeholder: Painter,
    contentDescription: String?,
    contentScale: ContentScale,
    modifier: Modifier = Modifier,
) {
    if (LocalInspectionMode.current) {
        Box(
            modifier = modifier
                .defaultMinSize(24.dp, 24.dp)
                .background(color = Color.Magenta)
        )
    } else {
        AsyncImage(
            model = url,
            contentDescription = contentDescription,
            placeholder = placeholder,
            modifier = modifier,
            contentScale = contentScale,
        )
    }

}