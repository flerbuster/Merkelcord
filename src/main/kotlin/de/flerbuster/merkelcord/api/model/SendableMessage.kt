package de.flerbuster.merkelcord.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SendableMessage(
    @SerialName("mobile_network_type")
    val mobileNetworkType: String,
    val content: String,
    val nonce: String,
    val tts: Boolean,
    val flags: Int,
    val attachments: List<DiscordMessageAttachment>
) {
    companion object {
        fun onlyContent(content: String) = SendableMessage(
            "unkown",
            content,
            generateNonce(),
            false,
            0,
            listOf()
        )

        fun generateNonce(): String {
            val list = List(19) { (0..9).random() }
            return list.joinToString("")
        }
    }
}