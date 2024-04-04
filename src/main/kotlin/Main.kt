import androidx.compose.ui.graphics.toPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.auth.AuthManager
import de.flerbuster.merkelcord.auth.ui.AccountAdd
import de.flerbuster.merkelcord.auth.ui.AccountManagement
import de.flerbuster.merkelcord.auth.ui.AccountSelect
import de.flerbuster.merkelcord.ui.Merkelcord
import de.flerbuster.merkelcord.ui.coloring.init
import de.flerbuster.merkelcord.ui.util.imagePainter
import java.io.File
import javax.imageio.ImageIO

fun main() = application {
    val painter = imagePainter("https://cdn.discordapp.com/avatars/418402550556000257/dd704fa022b7fdb82a6de9af4426235f.png")

    Window(onCloseRequest = ::exitApplication, title = "Merkelcord", icon = painter) {
        init()

        if (AuthManager.isLoggedIn) {
            Merkelcord()
        } else {
            AccountManagement()
        }
    }
}
