package de.flerbuster.merkelcord.api.websocket.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("DiscordHeartbeatAck")
data class DiscordHeartbeatAck(
    override val t: String? = null,
    override val s: String? = null,
    override val op: Int?,
    @SerialName("d")
    val data: String? = null
) : DiscordMessage()