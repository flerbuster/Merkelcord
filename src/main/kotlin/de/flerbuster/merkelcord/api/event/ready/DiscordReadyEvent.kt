package de.flerbuster.merkelcord.api.event.ready

import de.flerbuster.merkelcord.api.event.shared.channel.PrivateChannel
import de.flerbuster.merkelcord.api.event.shared.client.NotificationSettings
import de.flerbuster.merkelcord.api.event.shared.client.Presence
import de.flerbuster.merkelcord.api.event.shared.client.ReadState
import de.flerbuster.merkelcord.api.event.shared.client.Session
import de.flerbuster.merkelcord.api.event.shared.other.Auth
import de.flerbuster.merkelcord.api.event.shared.other.Consents
import de.flerbuster.merkelcord.api.event.shared.other.Relationship
import de.flerbuster.merkelcord.api.event.shared.user.Guild
import de.flerbuster.merkelcord.api.event.shared.user.User
import de.flerbuster.merkelcord.api.event.shared.user.UserGuildSetting
import de.flerbuster.merkelcord.api.event.shared.user.UserSettings
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscordReadyEvent(
    @SerialName("v")
    val version: Int?,
    @SerialName("user_settings_proto")
    val userSettingsProto: String?,
    @SerialName("user_settings")
    val userSettings: UserSettings?,
    @SerialName("user_guild_settings")
    val userGuildSettings: List<UserGuildSetting>?,
    val user: User?,
    val sessions: List<Session>?,
    @SerialName("session_type")
    val sessionType: String?,
    @SerialName("session_id")
    val sessionId: String?,
    @SerialName("resume_gateway_url")
    val resumeGatewayUrl: String?,
    val relationships: List<Relationship>?,
    @SerialName("read_state")
    val readState: List<ReadState>?,
    @SerialName("private_channels")
    val privateChannels: List<PrivateChannel>?,
    val presences: List<Presence>?,
    @SerialName("notification_settings")
    val notificationSettings: NotificationSettings?,
    // val notes: List<Note>?, Exception in thread "AWT-EventQueue-0" kotlinx.serialization.json.internal.JsonDecodingException: Expected class kotlinx.serialization.json.JsonArray (Kotlin reflection is not available) as the serialized body of kotlin.collections.ArrayList, but had class kotlinx.serialization.json.JsonObject (Kotlin reflection is not available)
    val guilds: List<Guild>?,
    @SerialName("geo_ordered_rtc_regions")
    val geoOrderedRtcRegions: List<String>?,
    @SerialName("friend_suggestion_count")
    val friendSuggestionCount: Int?,
    val experiments: List<List<Long>>?,
    @SerialName("country_code")
    val countryCode: String?,
    val consents: Consents?,
    @SerialName("auth_session_id_hash")
    val authSessionIdHash: String?,
    val auth: Auth?,
    @SerialName("api_code_version")
    val apiCodeVersion: Int?,
    @SerialName("analytics_token")
    val analyticsToken: String?,
    @SerialName("_trace")
    val trace: List<String>?
)