package de.flerbuster.merkelcord.api.event.voice

import de.flerbuster.merkelcord.api.event.shared.user.Member
import kotlinx.serialization.Serializable

@Serializable
data class VoiceStateUpdateEvent(
    val member: Member?
)