package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SoundboardSound(
    val volume: Double?,
    @SerialName("user_id")
    val userId: String?,
    @SerialName("sound_id")
    val soundId: String?,
    val name: String?,
    @SerialName("guild_id")
    val guildId: String?,
    @SerialName("emoji_name")
    val emojiName: String?,
    @SerialName("emoji_id")
    val emojiId: String?,
    val available: Boolean?
)