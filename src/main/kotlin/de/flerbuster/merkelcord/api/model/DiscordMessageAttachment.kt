package de.flerbuster.merkelcord.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscordMessageAttachment(
    val filename: String,
    val id: String,
    @SerialName("uploaded_filename")
    val uploadedFilename: String
)