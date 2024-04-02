package de.flerbuster.merkelcord.api.event

import de.flerbuster.merkelcord.api.websocket.message.DiscordMessage
import de.flerbuster.merkelcord.api.websocket.message.DiscordReadyMessage
import de.flerbuster.merkelcord.api.websocket.message.MessageCreateMessage
import de.flerbuster.merkelcord.api.websocket.message.SessionsReplaceMessage
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

interface Event {
    companion object{
        fun selectDeserializer(element: JsonElement): KSerializer<out DiscordMessage> {
            val t = element.jsonObject["t"]?.jsonPrimitive?.content

            return when (t) {
                "READY" -> DiscordReadyMessage.serializer()
                "SESSIONS_REPLACE" -> SessionsReplaceMessage.serializer()
                "MESSAGE_CREATE" -> MessageCreateMessage.serializer()
                else -> error("unknown event: $element")
            }
        }
    }
}