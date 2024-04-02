package de.flerbuster.merkelcord.api.event.shared.channel


import de.flerbuster.merkelcord.api.event.shared.user.Member
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Thread(
    val type: Int?,
    @SerialName("total_message_sent")
    val totalMessageSent: Int?,
    @SerialName("thread_metadata")
    val threadMetadata: ThreadMetadata?,
    @SerialName("rate_limit_per_user")
    val rateLimitPerUser: Int?,
    @SerialName("parent_id")
    val parentId: String?,
    @SerialName("owner_id")
    val ownerId: String?,
    val name: String?,
    @SerialName("message_count")
    val messageCount: Int?,
    @SerialName("member_ids_preview")
    val memberIdsPreview: List<String?>?,
    @SerialName("member_count")
    val memberCount: Int?,
    val member: Member?,
    @SerialName("last_message_id")
    val lastMessageId: String?,
    val id: String?,
    @SerialName("guild_id")
    val guildId: String?,
    val flags: Int?
)