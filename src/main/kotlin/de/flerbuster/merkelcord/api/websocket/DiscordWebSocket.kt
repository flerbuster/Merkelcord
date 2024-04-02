package de.flerbuster.merkelcord.api.websocket

import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.api.websocket.message.DiscordReadyMessage
import de.flerbuster.merkelcord.api.websocket.message.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.serialization.encodeToString

class DiscordWebSocket(
    val token: String,
    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
) {
    companion object {
        val decodingJson = DiscordApi.decodingJson
        val encodingJson = DiscordApi.encodingJson

        val ktorClient = HttpClient(CIO) {
            install(WebSockets)
        }
    }

    var helloData: DiscordHelloMessage.DiscordHelloData? = null

    var session: DefaultClientWebSocketSession? = null
    var pendingIdentify = false

    val eventFlow = MutableSharedFlow<EventMessage>()

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
        val message = decodingJson.decodeFromString<DiscordMessage>(frame.readText())

        when (message) {
            is DiscordHelloMessage -> {
                pendingIdentify = true
                helloData = message.data
                startHeartbeat()
            }
            is DiscordHeartbeatAck -> {
                if (pendingIdentify) {
                    identify()
                    pendingIdentify = false
                }
            }
            is EventMessage -> {
                eventFlow.emit(message)
                println(message::class.qualifiedName)
            }

            else -> {
                println("${message::class.qualifiedName} is unhandled")
            }
        }

        // println("message: $message")
    }

    private suspend fun DefaultClientWebSocketSession.identify() {
        send(
            encodingJson.encodeToString(ClientSentIdentify(
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
        if (pendingIdentify) {
            identify()
            pendingIdentify = false
        }
        println(encodingJson.encodeToString(ClientSentHeartbeat()))
        send(encodingJson.encodeToString(ClientSentHeartbeat()))
    }

}


// keine ahnung wieso das nicht geht
inline fun <reified M : EventMessage> DiscordWebSocket.on(
    scope: CoroutineScope = this.scope,
    noinline consumer: M.() -> Unit
): Job =
    eventFlow.buffer(Channel.UNLIMITED).filterIsInstance<M>()
        .onEach { event ->
            scope.launch { runCatching { consumer(event) }.onFailure { println("fail: ${it.message}") } }
        }
        .launchIn(scope)
