package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sticker(
    val version: Long?,
    val type: Int?,
    val tags: String?,
    val name: String?,
    val id: String?,
    @SerialName("guild_id")
    val guildId: String?,
    @SerialName("format_type")
    val formatType: Int?,
    val description: String?,
    val available: Boolean?,
    val asset: String?
)