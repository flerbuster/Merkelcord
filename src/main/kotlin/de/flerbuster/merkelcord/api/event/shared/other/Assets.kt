package de.flerbuster.merkelcord.api.event.shared.other


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Assets(
    @SerialName("large_text")
    val largeText: String?,
    @SerialName("large_image")
    val largeImage: String?,
    @SerialName("small_text")
    val smallText: String?,
    @SerialName("small_image")
    val smallImage: String?
)