package de.flerbuster.merkelcord.api.event.shared.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildFolder(
    val name: String?,
    val id: Long?,
    @SerialName("guild_ids")
    val guildIds: List<String?>?,
    val color: Int?
)