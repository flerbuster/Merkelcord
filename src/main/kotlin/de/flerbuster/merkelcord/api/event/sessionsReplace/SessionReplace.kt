package de.flerbuster.merkelcord.api.event.sessionsReplace

import de.flerbuster.merkelcord.api.event.shared.user.Activity
import de.flerbuster.merkelcord.api.event.shared.client.ClientInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SessionReplace(
    val status: String,
    @SerialName("session_id")
    val sessionId: String,
    val clientInfo: ClientInfo?,
    val activities: List<Activity>?
)