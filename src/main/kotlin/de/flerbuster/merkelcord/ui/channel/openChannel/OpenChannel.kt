package de.flerbuster.merkelcord.ui.channel.openChannel

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.api.event.shared.channel.BaseChannel
import de.flerbuster.merkelcord.api.event.shared.message.Message
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import kotlinx.coroutines.launch

@Composable
fun OpenChannel(
    channel: BaseChannel,
    api: DiscordApi?,
    modifier: Modifier
) {
    val scope = rememberCoroutineScope()

    var fetched by remember(channel) { mutableStateOf(false) }
    val messages = remember(channel) { mutableStateListOf<Message>() }

    if (!fetched) scope.launch {
        fetched = true
        api?.getMessages(channel.id)?.let { messages.addAll(it) }
    }

    LazyColumn(
        modifier = modifier
    ) { // Server
        items(messages) {
            MerkelcordText(it.content)
        }
    }
}