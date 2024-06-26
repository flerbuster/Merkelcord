package de.flerbuster.merkelcord.ui.channel.dmChannels

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.event.shared.channel.PrivateChannel
import de.flerbuster.merkelcord.ui.coloring.colorScheme
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import de.flerbuster.merkelcord.ui.util.MerkelcordVerticalScrollbar
import java.awt.Cursor

@Composable
fun DmChannels(
    users: List<PrivateChannel>,
    modifier: Modifier,
    onOpen: (channel: PrivateChannel) -> Unit
) {
    val sorted = users.sortedBy { channel ->
        -(channel.lastMessageId?.toLongOrNull() ?: 0)
    }

    val state = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = state
    ) { // Server
        items(sorted) { channel ->
            DmChannel(channel, onOpen)
        }
    }

    MerkelcordVerticalScrollbar(state)
}

@Composable
fun DmChannel(
    channel: PrivateChannel,
    onOpen: (channel: PrivateChannel) -> Unit
) {
    val user = channel.recipients?.firstOrNull() ?: return

    val painter = user.avatarPainter

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(5.dp)
            .clickable { onOpen(channel) }
            .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
            .fillMaxWidth()
    ) {
        Image(
            painter = painter,
            contentDescription = "user avatar",
            modifier = Modifier.size(35.dp).clip(RoundedCornerShape(50))
        )

        MerkelcordText("  " + (user.username ?: user.globalName ?: "auf achse"))

    }
}