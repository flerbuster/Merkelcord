package de.flerbuster.merkelcord.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.api.event.ready.DiscordReadyEvent
import de.flerbuster.merkelcord.api.event.shared.channel.BaseChannel
import de.flerbuster.merkelcord.api.event.shared.channel.PrivateChannel
import de.flerbuster.merkelcord.api.event.shared.guild.Guild
import de.flerbuster.merkelcord.api.websocket.DiscordWebSocket
import de.flerbuster.merkelcord.api.websocket.message.MessageCreateMessage
import de.flerbuster.merkelcord.api.websocket.on
import de.flerbuster.merkelcord.auth.AuthManager
import de.flerbuster.merkelcord.ui.channel.dmChannels.DmChannels
import de.flerbuster.merkelcord.ui.channel.openChannel.OpenChannel
import de.flerbuster.merkelcord.ui.coloring.colorScheme
import de.flerbuster.merkelcord.ui.guild.guildSelect.GuildSelect
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import kotlinx.coroutines.launch

val websockets = hashMapOf<String, DiscordWebSocket>()
val apis = hashMapOf<String, DiscordApi>()

suspend fun getOrCreateWebsocket(token: String, onReady: DiscordReadyEvent.() -> Unit = { }): DiscordWebSocket {
    val current = websockets[token]
    if (current != null) {
        //current.readyEvent?.let { onReady(it) }
        return current
    }
    val new = DiscordWebSocket(token)
    websockets[token] = new

    new.connect(onReady)

    return new
}

@Composable
fun Merkelcord() {
    val websocketScope = rememberCoroutineScope()

    val token = AuthManager.token!!

    val guilds = remember { mutableStateListOf<Guild>() }
    val privateChannels = remember { mutableStateListOf<PrivateChannel>() }

    var websocket by mutableStateOf<DiscordWebSocket?>(null)

    websocketScope.launch {
        websocket = getOrCreateWebsocket(token) {
            this.guilds?.let { guilds.addAll(it) }
            this.privateChannels?.let { privateChannels.addAll(it) }
        }
    }

    val apiScope = rememberCoroutineScope()

    var api by remember { mutableStateOf<DiscordApi?>(null) }

    apiScope.launch {
        api = DiscordApi(token)
    }

    var openChannel by remember { mutableStateOf<BaseChannel?>(null) }
    val openGuild by remember { mutableStateOf<Guild?>(null) }

    Row {
        GuildSelect(guilds, Modifier.width(80.dp).background(colorScheme.guildsBackground).fillMaxHeight())

        if (openGuild == null) {
            DmChannels(privateChannels, Modifier.width(230.dp).fillMaxHeight().background(colorScheme.channelsBackground)) {
                openChannel = it
            }
        }

        if (openChannel != null) {
            OpenChannel(openChannel!!, api, Modifier.fillMaxSize().background(colorScheme.messagesBackground))
        } else {
            Column(
                modifier = Modifier.fillMaxSize().background(colorScheme.messagesBackground),
                verticalArrangement = Arrangement.Center
            ) {
                MerkelcordText("Kanal auswählen", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
