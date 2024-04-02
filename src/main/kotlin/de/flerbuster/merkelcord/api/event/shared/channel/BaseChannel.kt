package de.flerbuster.merkelcord.api.event.shared.channel

import kotlinx.serialization.Serializable

abstract class BaseChannel(
    open val id: String,
    open val lastMessageId: String?
) {
    constructor() : this("", "")
}