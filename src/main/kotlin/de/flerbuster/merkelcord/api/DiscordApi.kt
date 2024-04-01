package de.flerbuster.merkelcord.api

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class DiscordApi(
    val token: String
) {
    companion object {
        val json = Json {
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = true
        }

        val ktorClient = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(json)
            }
        }
    }
}