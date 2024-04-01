package de.flerbuster.merkelcord.api.websocket.message

import de.flerbuster.merkelcord.api.websocket.ClientOpCode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("ClientSentIdentify")
data class ClientSentIdentify(
    @SerialName("d")
    val data: IdentifyData,
    override val op: Int? = ClientOpCode.Identify.code,
    override val t: String? = null,
    override val s: String? = null,
) : DiscordMessage() {
    @Serializable
    data class IdentifyData(
        val token: String,
        val properties: Map<String, String>,
        @SerialName("large_threshold")
        val largeThreshold: Int = 250,
        val intents: Int = 3276799
    )
}