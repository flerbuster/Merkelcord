package de.flerbuster.merkelcord.api.event.shared.user


import de.flerbuster.merkelcord.api.event.shared.channel.ChannelOverride
import de.flerbuster.merkelcord.api.event.shared.other.MuteConfig
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserGuildSetting(
    val version: Int?,
    @SerialName("suppress_roles")
    val suppressRoles: Boolean?,
    @SerialName("suppress_everyone")
    val suppressEveryone: Boolean?,
    @SerialName("notify_highlights")
    val notifyHighlights: Int?,
    val muted: Boolean?,
    @SerialName("mute_scheduled_events")
    val muteScheduledEvents: Boolean?,
    @SerialName("mute_config")
    val muteConfig: MuteConfig?,
    @SerialName("mobile_push")
    val mobilePush: Boolean?,
    @SerialName("message_notifications")
    val messageNotifications: Int?,
    @SerialName("hide_muted_channels")
    val hideMutedChannels: Boolean?,
    @SerialName("guild_id")
    val guildId: String?,
    val flags: Int?,
    @SerialName("channel_overrides")
    val channelOverrides: List<ChannelOverride?>?
)