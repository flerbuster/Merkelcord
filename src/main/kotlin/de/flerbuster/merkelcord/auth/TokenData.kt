package de.flerbuster.merkelcord.auth

import androidx.compose.ui.graphics.painter.Painter
import de.flerbuster.merkelcord.ui.util.imagePainter
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class TokenData(
    val username: String,
    val avatarUrl: String,
    val token: String
) {

    @Transient
    private var _painter: Painter? = null
    val avatarPainter: Painter
        get() {
            if (_painter != null) return _painter!!
            _painter = imagePainter(avatarUrl)
            return _painter!!
        }
}