package de.flerbuster.merkelcord.ui.coloring

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import de.flerbuster.merkelcord.ui.coloring.scheme.DiscordColorScheme
import de.flerbuster.merkelcord.ui.coloring.scheme.darkColorScheme
import de.flerbuster.merkelcord.ui.coloring.scheme.lightColorScheme
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

var isDark = true

@Composable
fun init() {
    isDark = isSystemInDarkTheme()

    val file = File("./.run/coloring.json").also {
        it.createNewFile()
    }

    try {
        val data = Json.decodeFromString<ColoringData>(file.readText())
        isDark = data.useDark
    } catch (e: Exception) {
        println("error parsing file")
        file.writeText(Json.encodeToString(ColoringData(isDark)))
    }
}

@Serializable
data class ColoringData @OptIn(ExperimentalSerializationApi::class) constructor(
    @EncodeDefault
    val useDark: Boolean = true
)

val colorScheme: DiscordColorScheme
    get() = if (isDark) darkColorScheme else lightColorScheme