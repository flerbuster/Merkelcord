package de.flerbuster.merkelcord.api.event.shared.other


import de.flerbuster.merkelcord.api.event.shared.user.User
import kotlinx.serialization.Serializable

@Serializable
data class Relationship(
    val user: User?,
    val type: Int?,
    val nickname: String?,
    val id: String?,
    val since: String?
)