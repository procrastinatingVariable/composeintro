# What you'll need

### Design elements

![](/Users/gabriel/AndroidStudioProjects/composeintro/app/src/main/references/desert_design.jpg)

### Cheat sheet

#### Modifiers

[All Compose modifiers](https://developer.android.com/jetpack/compose/modifiers-list)

`Modifier.clickable`<br>
`Modifier.background`<br>
`Modifier.border`<br>
`Modifier.verticalScroll`<br>
`Modifier.horizontalScroll`<br>
`Modifier.height`<br>
`Modifier.width`<br>
`Modifier.fillMaxWidth`<br>
`Modifier.fillMaxHeight`<br>
`Modifier.size`<br>
`Modifier.padding`<br>

#### Layouts

[Box](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Box(androidx.compose.ui.Modifier))<br>
[Row](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Row(androidx.compose.ui.Modifier,androidx.compose.foundation.layout.Arrangement.Horizontal,androidx.compose.ui.Alignment.Vertical,kotlin.Function1))<br>
[Column](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Column(androidx.compose.ui.Modifier,androidx.compose.foundation.layout.Arrangement.Vertical,androidx.compose.ui.Alignment.Horizontal,kotlin.Function1))<br>

#### Components

Text<br>
[Spacer](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/package-summary#Spacer(androidx.compose.ui.Modifier))<br>
[**
UrlImage**](/Users/gabriel/AndroidStudioProjects/composeintro/app/src/main/java/com/google/composeintro/ui/common/UrlImage.kt)<br>
Image Composable that allows us to download and display images hosted online<br>
It behaves similar to Compose's **Image** Composable
documented [here](https://developer.android.com/reference/kotlin/androidx/compose/foundation/package-summary#Image(androidx.compose.ui.graphics.painter.Painter,kotlin.String,androidx.compose.ui.Modifier,androidx.compose.ui.Alignment,androidx.compose.ui.layout.ContentScale,kotlin.Float,androidx.compose.ui.graphics.ColorFilter))
