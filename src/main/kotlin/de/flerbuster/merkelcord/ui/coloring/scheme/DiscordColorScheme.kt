package de.flerbuster.merkelcord.ui.coloring.scheme

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color

class DiscordColorScheme(
    val guildsBackground: Color,
    val channelsBackground: Color,
    val messagesBackground: Color,

    val primaryText: Color,

    val scrollbarColor: Color,
    val scrollbarThumbColor: Color,
    val scrollbarThumbHoverColor: Color,

    val textInputButtonColor: Color,
    val textInputColor: Color,

)

val lightColorScheme = DiscordColorScheme(
    guildsBackground = Color.White,
    channelsBackground = Color.White,
    messagesBackground = Color.White,

    primaryText = Color.Black,

    scrollbarColor = Color(230, 230, 230),
    scrollbarThumbColor = Color(200, 200, 200),
    scrollbarThumbHoverColor = Color(175, 175, 175),

    textInputButtonColor = Color(0, 137, 123),
    textInputColor = Color.White,
)

val darkColorScheme = DiscordColorScheme(
    guildsBackground = Color(24, 24, 24),
    channelsBackground = Color(28, 28, 28),
    messagesBackground = Color(32, 32, 32),

    primaryText = Color(230, 230, 230),

    scrollbarColor = Color(31, 28, 29),
    scrollbarThumbColor = Color(23, 21, 25),
    scrollbarThumbHoverColor = Color(17, 15, 19),

    textInputButtonColor = Color(0, 137, 123),
    textInputColor = Color(37, 32, 35),
)