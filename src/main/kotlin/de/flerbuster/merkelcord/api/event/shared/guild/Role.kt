package de.flerbuster.merkelcord.api.event.shared.guild


import de.flerbuster.merkelcord.api.event.shared.other.Tags
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val version: Long?,
    @SerialName("unicode_emoji")
    val unicodeEmoji: String?,
    val tags: Tags?,
    val position: Int?,
    @SerialName("permissions_new")
    val permissionsNew: String?,
    val permissions: Int?,
    val name: String?,
    val mentionable: Boolean?,
    val managed: Boolean?,
    val id: String?,
    val icon: String?,
    val hoist: Boolean?,
    val flags: Int?,
    val color: Int?
)