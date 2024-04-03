package de.flerbuster.merkelcord.ui.guild.guildSelect

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.api.event.shared.guild.Guild
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import de.flerbuster.merkelcord.ui.util.MerkelcordVerticalScrollbar
import de.flerbuster.merkelcord.ui.util.imagePainter
import kotlinx.coroutines.launch

@Composable
fun GuildSelect(guilds: List<Guild>, modifier: Modifier) {
    val state = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        state = state
    ) {
        items(guilds) { guild ->
            Guild(guild, Modifier.size(45.dp))
        }
    }

    MerkelcordVerticalScrollbar(state)
}

@Composable
private fun Guild(guild: Guild, modifier: Modifier) {
    val painter = guild.iconPainter

    Image(
        painter = painter,
        modifier = modifier.clip(RoundedCornerShape(50)),
        contentDescription = "${guild.name}"
    )
    Row(modifier = Modifier.height(10.dp)) {  }
}