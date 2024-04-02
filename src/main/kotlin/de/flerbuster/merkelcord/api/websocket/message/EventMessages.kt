package de.flerbuster.merkelcord.api.websocket.message

import de.flerbuster.merkelcord.api.event.message.MessageAckEvent
import de.flerbuster.merkelcord.api.event.message.MessageCreateEvent
import de.flerbuster.merkelcord.api.event.presence.PresenceUpdateEvent
import de.flerbuster.merkelcord.api.event.ready.DiscordReadyEvent
import de.flerbuster.merkelcord.api.event.sessionsReplace.SessionsReplaceEvent
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class EventMessage : DiscordMessage()

@Serializable
data class DiscordReadyMessage(
    override val t: String?,
    override val s: String?,
    override val op: Int?,
    @SerialName("d")
    val data: DiscordReadyEvent?
) : EventMessage()


@Serializable
data class SessionsReplaceMessage(
    override val t: String?,
    override val s: String?,
    override val op: Int?,
    @SerialName("d")
    val data: SessionsReplaceEvent?
) : EventMessage()


@Serializable
data class MessageCreateMessage(
    override val t: String?,
    override val s: String?,
    override val op: Int?,
    @SerialName("d")
    val data: MessageCreateEvent?
) : EventMessage()



@Serializable
data class MessageAckMessage(
    override val t: String?,
    override val s: String?,
    override val op: Int?,
    @SerialName("d")
    val data: MessageAckEvent?
) : EventMessage()


@Serializable
data class PresenceUpdateMessage(
    override val t: String?,
    override val s: String?,
    override val op: Int?,
    @SerialName("d")
    val data: PresenceUpdateEvent?
) : EventMessage()