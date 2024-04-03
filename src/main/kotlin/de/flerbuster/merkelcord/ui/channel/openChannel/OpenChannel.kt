package de.flerbuster.merkelcord.ui.channel.openChannel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.api.event.shared.channel.BaseChannel
import de.flerbuster.merkelcord.api.event.shared.message.Message
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import de.flerbuster.merkelcord.ui.util.MerkelcordVerticalScrollbar
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

    val state = rememberLazyListState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(5.dp),
                state = state
            ) {
                items(messages) {
                    MerkelcordText(it.content ?: "")
                }
            }

            // keine ahnung wieso das links ist
            MerkelcordVerticalScrollbar(state)

        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Messagebar(channel.id) {
                scope.launch {
                    api?.sendMessage(channel.id, it)
                }
            }
        }

    }
}