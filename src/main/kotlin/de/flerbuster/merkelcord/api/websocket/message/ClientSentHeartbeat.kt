package de.flerbuster.merkelcord.api.websocket.message

import de.flerbuster.merkelcord.api.websocket.ClientOpCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ClientSentHeartbeat")
data class ClientSentHeartbeat(
    override val t: String? = null,
    override val s: String? = null,
    override val op: Int? = ClientOpCode.Heartbeat.code,
    @SerialName("d")
    val data: String? = null
) : DiscordMessage()