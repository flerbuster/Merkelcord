package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Emoji(
    val version: Long?,
    val roles: List<String?>?,
    @SerialName("require_colons")
    val requireColons: Boolean?,
    val name: String?,
    val managed: Boolean?,
    val id: String?,
    val available: Boolean?,
    val animated: Boolean?
)