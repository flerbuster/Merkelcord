import androidx.compose.ui.graphics.toPainter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.ui.Merkelcord
import de.flerbuster.merkelcord.ui.coloring.init
import java.io.File
import javax.imageio.ImageIO

fun main() = application {
    val painter = ImageIO.read(File("./merkel.png")).toPainter()

    Window(onCloseRequest = ::exitApplication, title = "Merkelcord", icon = painter) {
        init()

        Merkelcord()
    }
}
