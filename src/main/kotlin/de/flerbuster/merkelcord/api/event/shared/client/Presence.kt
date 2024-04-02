package de.flerbuster.merkelcord.api.event.shared.client


import de.flerbuster.merkelcord.api.event.shared.user.Activity
import de.flerbuster.merkelcord.api.event.shared.user.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Presence(
    val user: User?,
    val status: String?,
    @SerialName("last_modified")
    val lastModified: Long?,
    @SerialName("client_status")
    val clientStatus: ClientStatus?,
    val activities: List<Activity>?
)