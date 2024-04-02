package de.flerbuster.merkelcord.api.event.shared.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PermissionOverwrite(
    val type: String?,
    val id: String?,
    @SerialName("deny_new")
    val denyNew: String?,
    val deny: Int?,
    @SerialName("allow_new")
    val allowNew: String?,
    val allow: Int?
)