package de.flerbuster.merkelcord.api.event.shared.user


import de.flerbuster.merkelcord.api.event.shared.other.MuteConfig
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val muted: Boolean?,
    @SerialName("mute_config")
    val muteConfig: MuteConfig?,
    @SerialName("join_timestamp")
    val joinTimestamp: String?,
    val flags: Int?
)