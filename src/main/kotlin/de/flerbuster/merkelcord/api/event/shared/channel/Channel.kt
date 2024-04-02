package de.flerbuster.merkelcord.api.event.shared.channel


import de.flerbuster.merkelcord.api.event.shared.other.AvailableTag
import de.flerbuster.merkelcord.api.event.shared.other.DefaultReactionEmoji
import de.flerbuster.merkelcord.api.event.shared.other.IconEmoji
import de.flerbuster.merkelcord.api.event.shared.guild.PermissionOverwrite
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Channel(
    val version: Long?,
    val type: Int?,
    val topic: String?,
    @SerialName("rate_limit_per_user")
    val rateLimitPerUser: Int?,
    val position: Int?,
    @SerialName("permission_overwrites")
    val permissionOverwrites: List<PermissionOverwrite?>?,
    val name: String?,
    @SerialName("last_pin_timestamp")
    val lastPinTimestamp: String?,
    @SerialName("last_message_id")
    val lastMessageId: String?,
    val id: String?,
    @SerialName("icon_emoji")
    val iconEmoji: IconEmoji?,
    val flags: Int?,
    @SerialName("parent_id")
    val parentId: String?,
    @SerialName("user_limit")
    val userLimit: Int?,
    @SerialName("rtc_region")
    val bitrate: Int?,
    val nsfw: Boolean?,
    @SerialName("default_thread_rate_limit_per_user")
    val defaultThreadRateLimitPerUser: Int?,
    @SerialName("video_quality_mode")
    val videoQualityMode: Int?,
    @SerialName("default_auto_archive_duration")
    val defaultAutoArchiveDuration: Int?,
    val template: String?,
    @SerialName("default_reaction_emoji")
    val defaultReactionEmoji: DefaultReactionEmoji?,
    @SerialName("available_tags")
    val availableTags: List<AvailableTag?>?,
    @SerialName("default_forum_layout")
    val defaultForumLayout: Int?
)