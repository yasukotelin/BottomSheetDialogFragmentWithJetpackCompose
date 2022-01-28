package com.github.yasukotelin.bottomsheetdialogfragmenttwithjetpackcompose.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightColorPalette = lightColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = White,
    onBackground = Black,
)

@Composable
fun SampleTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = lightColorPalette,
        content = content,
    )
}