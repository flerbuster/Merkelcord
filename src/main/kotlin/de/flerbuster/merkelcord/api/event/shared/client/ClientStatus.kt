package de.flerbuster.merkelcord.api.event.shared.client


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientStatus(
    val mobile: String?,
    val desktop: String?,
    val web: String?
)