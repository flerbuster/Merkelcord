package de.flerbuster.merkelcord.api.websocket

import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.api.websocket.message.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString

class DiscordWebSocket(
    val token: String
) {
    companion object {
        val json = DiscordApi.json

        val ktorClient = HttpClient(CIO) {
            install(WebSockets)
        }
    }

    var helloData: DiscordHelloMessage.DiscordHelloData? = null

    var session: DefaultClientWebSocketSession? = null
    var pendingIdentify = false

    suspend fun connect() {
        ktorClient.webSocket("wss://gateway.discord.gg") {
            session = this


            while (true) {
                when (val frame = incoming.receive()) {
                    is Frame.Text -> handleText(frame)
                    else -> {}
                }
            }
        }
    }

    private suspend fun DefaultClientWebSocketSession.handleText(frame: Frame.Text) {
        val message = json.decodeFromString<DiscordMessage>(frame.readText())

        when (message) {
            is DiscordHelloMessage -> {
                pendingIdentify = true
                helloData = message.data
                startHeartbeat()
            }
            is DiscordHeartbeatAck -> {
                println("ack recieved")
                if (pendingIdentify) {
                    identify()
                    pendingIdentify = false
                }
            }


            else -> error("invalid message: $message")
        }

        println("message: $message")
    }

    private suspend fun DefaultClientWebSocketSession.identify() {
        send(json.encodeToString(ClientSentIdentify(
            ClientSentIdentify.IdentifyData(
                token,
                mapOf(
                    "\$os" to "merkelos",
                    "\$browser" to "chrome",
                    "\$device" to "crhome",
                )
            )
        )))
    }

    private suspend fun DefaultClientWebSocketSession.startHeartbeat() {
        sendHeartbeat()

        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(helloData?.heartbeatInterval?.toLong() ?: Long.MAX_VALUE)
                sendHeartbeat()
            }
        }
    }

    private suspend fun DefaultClientWebSocketSession.sendHeartbeat() {
        send(json.encodeToString(ClientSentHeartbeat()))
    }
}