package de.flerbuster.merkelcord.api.event.shared.user

import androidx.compose.ui.graphics.painter.Painter
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.ui.util.imagePainter
import kotlinx.serialization.Transient

abstract class BaseUser {
    abstract val id: String?
    abstract val avatar: String?

    @Transient
    private var _painter: Painter? = null
    val avatarPainter: Painter
    get() {
        if (_painter != null) return _painter!!
        _painter = imagePainter(DiscordApi.userAvatar(id ?: "", avatar))
        return _painter!!
    }
}