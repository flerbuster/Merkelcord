package de.flerbuster.merkelcord.api.event.shared.user


import de.flerbuster.merkelcord.api.event.shared.other.AvatarDecorationData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipient(
    val username: String?,
    @SerialName("public_flags")
    val publicFlags: Int?,
    val id: String?,
    @SerialName("global_name")
    val globalName: String?,
    val discriminator: String?,
    @SerialName("avatar_decoration_data")
    val avatarDecorationData: AvatarDecorationData?,
    val avatar: String?,
    val bot: Boolean?
)