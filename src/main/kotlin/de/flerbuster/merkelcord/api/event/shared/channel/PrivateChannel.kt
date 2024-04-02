package de.flerbuster.merkelcord.api.event.shared.channel


import de.flerbuster.merkelcord.api.event.shared.user.Recipient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PrivateChannel(
    val type: Int?,
    val recipients: List<Recipient>?,
    @SerialName("last_message_id")
    val lastMessageId: String?,
    @SerialName("is_spam")
    val isSpam: Boolean?,
    val id: String?,
    val flags: Int?,
    @SerialName("last_pin_timestamp")
    val lastPinTimestamp: String?,
    @SerialName("owner_id")
    val ownerId: String?,
    val name: String?,
    val icon: String?,
    @SerialName("is_message_request_timestamp")
    val isMessageRequestTimestamp: String?,
    @SerialName("is_message_request")
    val isMessageRequest: Boolean?
)