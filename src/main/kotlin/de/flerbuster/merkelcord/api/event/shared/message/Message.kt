package de.flerbuster.merkelcord.api.event.shared.message

import de.flerbuster.merkelcord.api.event.shared.user.User
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val type: Int?,
    val tts: Boolean?,
    val timestamp: Instant?,
    @SerialName("referenced_message")
    val referencedMessage: Message?,
    val pinned: Boolean?,
    val nonce: String?,
    val mentions: List<User>?,
    // @SerialName("mention_roles")
    // val mentionRoles: List<Role>
    @SerialName("mention_everyone")
    val mentionEveryone: Boolean?,
    val id: String?,
    val flags: Int?,
    // val embeds: List<Embed>
    @SerialName("edited_timestamp")
    val editedTimestamp: Instant?,
    val content: String?,
    // val components: List<Component>
    @SerialName("channel_id")
    val channelId: String?,
    val author: User?, // Author
    // val attachments: List<Attachment>
)