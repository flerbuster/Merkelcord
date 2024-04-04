package de.flerbuster.merkelcord.ui.channel.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.event.shared.message.Message
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import java.awt.Cursor

@Composable
fun Message(
    message: Message,
    drawUser: Boolean
) {
    val avatar = message.author?.avatarPainter

    val userName = message.author?.username ?: message.author?.globalName ?: ""

    val messageHeight = 35.dp
    val spacerSize = 3.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(spacerSize)
    ) {
        if (drawUser && avatar != null) {
            Image(
                avatar,
                modifier = Modifier.size(messageHeight).clip(RoundedCornerShape(50)),
                contentDescription = "user: ${message.author.globalName}"
            )

            Spacer(modifier = Modifier.width(spacerSize))
        } else {
            Spacer(modifier = Modifier.height(messageHeight).width(messageHeight + spacerSize))
        }

        Column {
            if (drawUser) {
                MerkelcordText(userName)
            }

            MerkelcordText(message.content ?: "", selectable = true)
        }
    }
}
