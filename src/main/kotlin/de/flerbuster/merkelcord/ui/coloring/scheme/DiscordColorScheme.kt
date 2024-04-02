package de.flerbuster.merkelcord.ui.coloring.scheme

import androidx.compose.ui.graphics.Color

class DiscordColorScheme(
    val guildsBackground: Color,
    val channelsBackground: Color,
    val messagesBackground: Color,

    val primaryText: Color
)

val lightColorScheme = DiscordColorScheme(
    guildsBackground = Color.White,
    channelsBackground = Color.White,
    messagesBackground = Color.White,

    primaryText = Color.Black
)

val darkColorScheme = DiscordColorScheme(
    guildsBackground = Color(24, 24, 24),
    channelsBackground = Color(28, 28, 28),
    messagesBackground = Color(32, 32, 32),

    primaryText = Color(230, 230, 230)
)