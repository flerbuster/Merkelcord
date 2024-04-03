package de.flerbuster.merkelcord.api.event.shared.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val user: User,
    // val roles: List<Any>,
    // @SerialName("premium_since")
    // val premiumSince: Any?,
    val pending: Boolean,
    val nick: String?,
    val mute: Boolean,
    @SerialName("joined_at")
    val joinedAt: String,
    val flags: Int,
    val deaf: Boolean,
    // @SerialName("communication_disabled_until")
    // val communicationDisabledUntil: Any?,
    val avatar: String?
)