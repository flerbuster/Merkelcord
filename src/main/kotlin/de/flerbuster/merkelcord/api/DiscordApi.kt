package de.flerbuster.merkelcord.api

import de.flerbuster.merkelcord.api.event.shared.message.Message
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

class DiscordApi(
    val token: String
) {
    companion object {
        @OptIn(ExperimentalSerializationApi::class)
        val decodingJson = Json {
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        }

        val encodingJson = Json {
            encodeDefaults = true
        }

        val ktorClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(decodingJson)
            }
        }

        const val BASE_URL = "https://discord.com/api/v9"

        fun userAvatar(userId: String, userAvatar: String?): String {
            if (userAvatar?.startsWith("https") == true) return userAvatar
            var iconUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Placeholder_view_vector.svg/310px-Placeholder_view_vector.svg.png"
            if (userAvatar != null) iconUrl =  "https://cdn.discordapp.com/avatars/${userId}/${userAvatar}"
            return iconUrl
        }
    }

    private fun HttpRequestBuilder.default() {
        header(HttpHeaders.ContentType, "application/json")
        header("authorization", token)
    }

    private suspend inline fun <reified T> get(subUrl: String, block: HttpRequestBuilder.() -> Unit = { }): T? {
        val response = ktorClient.get(BASE_URL + subUrl) {
            default()

            block()
        }

        return try {
            response.body<T>()
        } catch (e: Exception) {
            println("request error: $e")
            null
        }
    }

    suspend fun getMessages(channelId: String, limit: Int = 100)
        = get<List<Message>>("/channels/$channelId/messages") {
            parameter("limit", limit)
        }
}