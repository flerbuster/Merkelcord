package de.flerbuster.merkelcord.api.event.shared.guild


import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildMember(
    val member: Member,
    @SerialName("user_id")
    val userId: String,
    val suppress: Boolean,
    @SerialName("session_id")
    val sessionId: String,
    @SerialName("self_video")
    val selfVideo: Boolean,
    @SerialName("self_mute")
    val selfMute: Boolean,
    @SerialName("self_deaf")
    val selfDeaf: Boolean,
    @SerialName("request_to_speak_timestamp")
    val requestToSpeakTimestamp: Instant?,
    val mute: Boolean,
    @SerialName("guild_id")
    val guildId: String,
    val deaf: Boolean,
    @SerialName("channel_id")
    val channelId: String?
)