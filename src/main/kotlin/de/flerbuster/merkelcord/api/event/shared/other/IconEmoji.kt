package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IconEmoji(
    val name: String?,
    val id: String?
)