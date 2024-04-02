package de.flerbuster.merkelcord.api.event.shared.user


import de.flerbuster.merkelcord.api.event.shared.other.FriendSourceFlags
import de.flerbuster.merkelcord.api.event.shared.guild.GuildFolder
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserSettings(
    @SerialName("detect_platform_accounts")
    val detectPlatformAccounts: Boolean?,
    @SerialName("animate_stickers")
    val animateStickers: Int?,
    @SerialName("inline_attachment_media")
    val inlineAttachmentMedia: Boolean?,
    val status: String?,
    @SerialName("message_display_compact")
    val messageDisplayCompact: Boolean?,
    @SerialName("view_nsfw_guilds")
    val viewNsfwGuilds: Boolean?,
    @SerialName("timezone_offset")
    val timezoneOffset: Int?,
    @SerialName("enable_tts_command")
    val enableTtsCommand: Boolean?,
    @SerialName("disable_games_tab")
    val disableGamesTab: Boolean?,
    @SerialName("stream_notifications_enabled")
    val streamNotificationsEnabled: Boolean?,
    @SerialName("animate_emoji")
    val animateEmoji: Boolean?,
    @SerialName("guild_folders")
    val guildFolders: List<GuildFolder?>?,
    @SerialName("activity_joining_restricted_guild_ids")
    val activityJoiningRestrictedGuildIds: List<String?>?,
    @SerialName("friend_source_flags")
    val friendSourceFlags: FriendSourceFlags?,
    @SerialName("convert_emoticons")
    val convertEmoticons: Boolean?,
    @SerialName("afk_timeout")
    val afkTimeout: Int?,
    val passwordless: Boolean?,
    @SerialName("contact_sync_enabled")
    val contactSyncEnabled: Boolean?,
    @SerialName("broadcast_allow_friends")
    val broadcastAllowFriends: Boolean?,
    @SerialName("gif_auto_play")
    val gifAutoPlay: Boolean?,
    @SerialName("native_phone_integration_enabled")
    val nativePhoneIntegrationEnabled: Boolean?,
    @SerialName("allow_accessibility_detection")
    val allowAccessibilityDetection: Boolean?,
    @SerialName("friend_discovery_flags")
    val friendDiscoveryFlags: Int?,
    @SerialName("show_current_game")
    val showCurrentGame: Boolean?,
    @SerialName("developer_mode")
    val developerMode: Boolean?,
    @SerialName("view_nsfw_commands")
    val viewNsfwCommands: Boolean?,
    @SerialName("render_reactions")
    val renderReactions: Boolean?,
    val locale: String?,
    @SerialName("render_embeds")
    val renderEmbeds: Boolean?,
    @SerialName("inline_embed_media")
    val inlineEmbedMedia: Boolean?,
    @SerialName("default_guilds_restricted")
    val defaultGuildsRestricted: Boolean?,
    @SerialName("explicit_content_filter")
    val explicitContentFilter: Int?,
    @SerialName("activity_restricted_guild_ids")
    val activityRestrictedGuildIds: List<String?>?,
    val theme: String?
)