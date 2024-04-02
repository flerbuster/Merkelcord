package de.flerbuster.merkelcord.api.event.shared.client


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val status: String?,
    @SerialName("session_id")
    val sessionId: String?,
    @SerialName("client_info")
    val clientInfo: ClientInfo?,
)