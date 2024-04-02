package de.flerbuster.merkelcord.api.event.shared.client


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ClientInfo(
    val version: Int?,
    val os: String?,
    val client: String?
)