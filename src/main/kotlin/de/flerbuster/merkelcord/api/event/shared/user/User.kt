package de.flerbuster.merkelcord.api.event.shared.user


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val verified: Boolean?,
    val username: String?,
    @SerialName("purchased_flags")
    val purchasedFlags: Int?,
    @SerialName("public_flags")
    val publicFlags: Int?,
    val pronouns: String?,
    @SerialName("premium_type")
    val premiumType: Int?,
    val premium: Boolean?,
    @SerialName("nsfw_allowed")
    val nsfwAllowed: Boolean?,
    val mobile: Boolean?,
    @SerialName("mfa_enabled")
    val mfaEnabled: Boolean?,
    val id: String?,
    @SerialName("global_name")
    val globalName: String?,
    val flags: Int?,
    val email: String?,
    val discriminator: String?,
    val desktop: Boolean?,
    val bio: String?,
    @SerialName("banner_color")
    val bannerColor: String?,
    val avatar: String?,
    @SerialName("accent_color")
    val accentColor: Int?
)