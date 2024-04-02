package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefaultReactionEmoji(
    @SerialName("emoji_name")
    val emojiName: String?,
    @SerialName("emoji_id")
    val emojiId: String?
)