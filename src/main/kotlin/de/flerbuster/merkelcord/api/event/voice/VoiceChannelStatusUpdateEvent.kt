package de.flerbuster.merkelcord.api.event.voice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoiceChannelStatusUpdateEvent(
    val status: String?,
    val id: String?,
    @SerialName("guild_id")
    val guildId: String?
)