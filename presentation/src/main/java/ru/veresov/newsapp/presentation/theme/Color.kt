package ru.veresov.newsapp.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class NewsAppColors(
    val backgroundColor: Color,
    val secondaryBackgroundColor: Color,
    val primaryTextColor: Color,
    val secondaryTextColor: Color,
    val primaryTextColorTransparent: Color,
)


val lightPalette = NewsAppColors(
    backgroundColor = Color(0xFF242C3B),
    secondaryBackgroundColor = Color(0xFF37B6E9),
    primaryTextColor = Color(0xFFFFFFFF),
    secondaryTextColor = Color(0xFF3C9EEA),
    primaryTextColorTransparent = Color(0x99FFFFFF),
)

val darkPalette = NewsAppColors(
    backgroundColor = Color(0xFF242C3B),
    secondaryBackgroundColor = Color(0xFF37B6E9),
    primaryTextColor = Color(0xFFFFFFFF),
    secondaryTextColor = Color(0xFF3C9EEA),
    primaryTextColorTransparent = Color(0x99FFFFFF),
)

val LocalNewsAppColorScheme = staticCompositionLocalOf {
    NewsAppColors(
        backgroundColor = Color(0xFF242C3B),
        secondaryBackgroundColor = Color(0xFF37B6E9),
        primaryTextColor = Color(0xFFFFFFFF),
        secondaryTextColor = Color(0xFF3C9EEA),
        primaryTextColorTransparent = Color(0x99FFFFFF),
    )
}