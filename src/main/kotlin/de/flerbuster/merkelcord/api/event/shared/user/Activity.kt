package de.flerbuster.merkelcord.api.event.shared.user


import de.flerbuster.merkelcord.api.event.shared.other.Assets
import de.flerbuster.merkelcord.api.event.shared.other.Party
import de.flerbuster.merkelcord.api.event.shared.other.Timestamps
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    val type: Int?,
    val state: String?,
    val name: String?,
    val id: String?,
    @SerialName("created_at")
    val createdAt: Long?,
    val timestamps: Timestamps?,
    @SerialName("application_id")
    val applicationId: String?,
    @SerialName("sync_id")
    val syncId: String?,
    @SerialName("session_id")
    val sessionId: String?,
    val party: Party?,
    val flags: Int?,
    val details: String?,
    val assets: Assets?
)