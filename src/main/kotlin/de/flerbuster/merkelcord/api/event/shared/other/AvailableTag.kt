package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AvailableTag(
    val name: String?,
    val moderated: Boolean?,
    val id: String?,
    @SerialName("emoji_name")
    val emojiName: String?,
    @SerialName("emoji_id")
    val emojiId: String?
)