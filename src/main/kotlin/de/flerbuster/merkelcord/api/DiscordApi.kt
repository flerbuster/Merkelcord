package de.flerbuster.merkelcord.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
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
    }
}