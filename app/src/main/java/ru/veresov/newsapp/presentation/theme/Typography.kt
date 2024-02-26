package ru.veresov.newsapp.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


data class NewsAppTypography(
    val headerLarge: TextStyle,
    val headerNormal: TextStyle,
    val bodyLarge: TextStyle,
    val bodyNormal: TextStyle,
    val bodyNormalBold: TextStyle,
    val bodySmall: TextStyle,
    val bodySmallMedium: TextStyle,
)


private val headerLarge = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 26.sp
)

private val headerNormal = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

private val bodyLarge = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 17.sp
)

private val bodyNormal = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp
)

private val bodyNormalBold = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 15.sp
)

private val bodySmall = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 13.sp
)

private val bodySmallMedium = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 13.sp
)

val typography = NewsAppTypography(
    headerLarge = headerLarge,
    headerNormal = headerNormal,
    bodyLarge = bodyLarge,
    bodyNormal = bodyNormal,
    bodyNormalBold = bodyNormalBold,
    bodySmall = bodySmall,
    bodySmallMedium = bodySmallMedium
)


val LocalNewsAppTypography = staticCompositionLocalOf<NewsAppTypography> {
    NewsAppTypography(
        headerLarge = headerLarge,
        headerNormal = headerNormal,
        bodyLarge = bodyLarge,
        bodyNormal = bodyNormal,
        bodyNormalBold = bodyNormalBold,
        bodySmall = bodySmall,
        bodySmallMedium = bodySmallMedium
    )

}