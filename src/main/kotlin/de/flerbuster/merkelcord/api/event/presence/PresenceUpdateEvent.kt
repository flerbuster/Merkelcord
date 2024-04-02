package de.flerbuster.merkelcord.api.event.presence

import de.flerbuster.merkelcord.api.event.Event
import de.flerbuster.merkelcord.api.event.shared.client.ClientStatus
import de.flerbuster.merkelcord.api.event.shared.client.Game
import de.flerbuster.merkelcord.api.event.shared.user.Activity
import de.flerbuster.merkelcord.api.event.shared.user.User
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresenceUpdateEvent(
    val user: User?,
    val status: String?,
    val roles: List<String?>?,
    @SerialName("premium_since")
    val premiumSince: Instant?,
    val nick: String?,
    @SerialName("guild_id")
    val guildId: String?,
    val game: Game?,
    @SerialName("client_status")
    val clientStatus: ClientStatus,
    val broadcast: String?,
    val activities: List<Activity>
) : Event