package de.flerbuster.merkelcord.ui.guild.guildSelect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.event.shared.user.Guild
import de.flerbuster.merkelcord.ui.coloring.colorScheme
import de.flerbuster.merkelcord.ui.util.MerkelcordText

@Composable
fun GuildSelect(guilds: List<Guild>, modifier: Modifier) {
    LazyColumn(
        modifier = modifier
    ) { // Server
        items(guilds) {
            MerkelcordText(it.name ?: "no name :(")
        }
    }
}