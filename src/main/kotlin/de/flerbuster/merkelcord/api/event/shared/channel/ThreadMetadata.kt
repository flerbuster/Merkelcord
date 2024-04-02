package de.flerbuster.merkelcord.api.event.shared.channel


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ThreadMetadata(
    val locked: Boolean?,
    @SerialName("create_timestamp")
    val createTimestamp: String?,
    @SerialName("auto_archive_duration")
    val autoArchiveDuration: Int?,
    val archived: Boolean?,
    @SerialName("archive_timestamp")
    val archiveTimestamp: String?
)