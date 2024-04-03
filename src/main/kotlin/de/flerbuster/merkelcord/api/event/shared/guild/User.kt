package de.flerbuster.merkelcord.api.event.shared.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    @SerialName("public_flags")
    val publicFlags: Int,
    val id: String,
    @SerialName("global_name")
    val globalName: String,
    @SerialName("display_name")
    val displayName: String,
    val discriminator: String,
    val bot: Boolean,
    @SerialName("avatar_decoration_data")
    val avatarDecorationData: AvatarDecorationData,
    val avatar: String
)