package de.flerbuster.merkelcord.ui.util

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toPainter
import java.net.URL
import javax.imageio.ImageIO

fun imagePainter(
    url: String
): Painter {
    val image = ImageIO.read(URL(url))

    return image.toPainter()
}