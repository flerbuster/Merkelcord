package de.flerbuster.merkelcord.api.event.shared.client


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadState(
    @SerialName("mention_count")
    val mentionCount: Int?,
    @SerialName("last_viewed")
    val lastViewed: Int?,
    @SerialName("last_pin_timestamp")
    val lastPinTimestamp: String?,
    @SerialName("last_message_id")
    val lastMessageId: String?,
    val id: String?,
    val flags: Int?
)