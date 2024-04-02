package de.flerbuster.merkelcord.api.event.shared.client


import de.flerbuster.merkelcord.api.event.shared.other.Assets
import de.flerbuster.merkelcord.api.event.shared.other.Emoji
import de.flerbuster.merkelcord.api.event.shared.other.Party
import de.flerbuster.merkelcord.api.event.shared.other.Timestamps
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val type: Int?,
    val state: String?,
    @SerialName("session_id")
    val sessionId: String?,
    val name: String?,
    val id: String?,
    @SerialName("created_at")
    val createdAt: Long?,
    val timestamps: Timestamps?,
    @SerialName("application_id")
    val applicationId: String?,
    @SerialName("sync_id")
    val syncId: String?,
    val party: Party?,
    val flags: Int?,
    val details: String?,
    val assets: Assets?,
    val emoji: Emoji?
)