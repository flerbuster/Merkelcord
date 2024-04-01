package de.flerbuster.merkelcord.api.websocket.message

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("HelloMessage")
data class DiscordHelloMessage(
    override val t: String?,
    override val s: String?,
    override val op: Int?,
    @SerialName("d")
    val data: DiscordHelloData
) : DiscordMessage() {
    @Serializable
    data class DiscordHelloData(
        @SerialName("heartbeat_interval")
        val heartbeatInterval: Int,
    )
}