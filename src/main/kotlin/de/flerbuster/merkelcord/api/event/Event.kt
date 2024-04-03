package de.flerbuster.merkelcord.api.event

import de.flerbuster.merkelcord.api.websocket.message.*
import kotlinx.serialization.KSerializer
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
                "PRESENCE_UPDATE" -> PresenceUpdateMessage.serializer()
                "MESSAGE_ACK" -> MessageAckMessage.serializer()
                "VOICE_STATE_UPDATE" -> VoiceStateUpdateMessage.serializer()
                "VOICE_CHANNEL_STATUS_UPDATE" -> VoiceChannelStatusUpdateMessage.serializer()
                else -> {
                    println("unknown event: $element")
                    DiscordEventMessage.serializer()
                }
            }
        }
    }
}