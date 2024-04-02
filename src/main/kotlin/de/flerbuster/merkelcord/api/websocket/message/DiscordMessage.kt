package de.flerbuster.merkelcord.api.websocket.message

import de.flerbuster.merkelcord.api.event.Event
import de.flerbuster.merkelcord.api.websocket.ClientOpCode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonContentPolymorphicSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

@Polymorphic
@Serializable(with=DiscordMessage.Companion::class)
sealed class DiscordMessage {
    abstract val t: String?
    abstract val s: String?
    abstract val op: Int?

    companion object : JsonContentPolymorphicSerializer<DiscordMessage>(DiscordMessage::class) {
        override fun selectDeserializer(element: JsonElement): KSerializer<out DiscordMessage> {
            val opCode = element.jsonObject["op"]?.jsonPrimitive?.content?.toIntOrNull()

            return when (opCode) {
                ClientOpCode.Hello.code -> DiscordHelloMessage.serializer()
                ClientOpCode.HeartbeatACK.code -> DiscordHeartbeatAck.serializer()
                ClientOpCode.Dispatch.code -> Event.selectDeserializer(element)

                else -> error("Unknown message type, element: $element")
            }
        }
    }
}