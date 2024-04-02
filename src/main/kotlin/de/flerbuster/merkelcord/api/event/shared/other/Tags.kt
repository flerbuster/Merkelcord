package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tags(
    @SerialName("bot_id")
    val botId: String?,
    @SerialName("integration_id")
    val integrationId: String?
)