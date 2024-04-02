package de.flerbuster.merkelcord.api.event.shared.channel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChannelOverride(
    val muted: Boolean?,
    @SerialName("message_notifications")
    val messageNotifications: Int?,
    val collapsed: Boolean?,
    @SerialName("channel_id")
    val channelId: String?,
    val flags: Int?
)