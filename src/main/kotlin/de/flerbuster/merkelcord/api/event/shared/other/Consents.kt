package de.flerbuster.merkelcord.api.event.shared.other


import de.flerbuster.merkelcord.api.event.shared.client.Personalization
import kotlinx.serialization.Serializable

@Serializable
data class Consents(
    val personalization: Personalization?
)