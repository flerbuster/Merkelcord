import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import de.flerbuster.merkelcord.api.websocket.DiscordWebSocket
import de.flerbuster.merkelcord.api.websocket.message.MessageCreateMessage
import de.flerbuster.merkelcord.api.websocket.on
import kotlinx.coroutines.launch

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        val scope = rememberCoroutineScope()
        scope.launch {
            val websocket = DiscordWebSocket("")
            websocket.connect()
        }
    }
}
