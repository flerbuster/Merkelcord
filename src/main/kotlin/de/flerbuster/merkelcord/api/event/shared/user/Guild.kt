package de.flerbuster.merkelcord.api.event.shared.user


import de.flerbuster.merkelcord.api.event.shared.channel.Channel
import de.flerbuster.merkelcord.api.event.shared.channel.Thread
import de.flerbuster.merkelcord.api.event.shared.client.ActivityInstances
import de.flerbuster.merkelcord.api.event.shared.client.Presence
import de.flerbuster.merkelcord.api.event.shared.guild.Role
import de.flerbuster.merkelcord.api.event.shared.other.ApplicationCommandCounts
import de.flerbuster.merkelcord.api.event.shared.other.Emoji
import de.flerbuster.merkelcord.api.event.shared.other.SoundboardSound
import de.flerbuster.merkelcord.api.event.shared.other.Sticker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Guild(
    @SerialName("default_message_notifications")
    val defaultMessageNotifications: Int?,
    val nsfw: Boolean?,
    val lazy: Boolean?,
    @SerialName("public_updates_channel_id")
    val publicUpdatesChannelId: String?,
    val stickers: List<Sticker>?,
    @SerialName("system_channel_flags")
    val systemChannelFlags: Int?,
    val channels: List<Channel>?,
    val splash: String?,
    val features: List<String>?,
    @SerialName("preferred_locale")
    val preferredLocale: String?,
    @SerialName("system_channel_id")
    val systemChannelId: String?,
    val id: String?,
    val emojis: List<Emoji>?,
    @SerialName("nsfw_level")
    val nsfwLevel: Int?,
    val name: String?,
    @SerialName("latest_onboarding_question_id")
    val latestOnboardingQuestionId: String?,
    @SerialName("rules_channel_id")
    val rulesChannelId: String?,
    @SerialName("afk_channel_id")
    val afkChannelId: String?,
    @SerialName("safety_alerts_channel_id")
    val safetyAlertsChannelId: String?,
    @SerialName("owner_id")
    val ownerId: String?,
    @SerialName("max_video_channel_users")
    val maxVideoChannelUsers: Int?,
    val threads: List<Thread>?,
    val members: List<Member>?,
    @SerialName("mfa_level")
    val mfaLevel: Int?,
    @SerialName("premium_tier")
    val premiumTier: Int?,
    @SerialName("max_stage_video_channel_users")
    val maxStageVideoChannelUsers: Int?,
    @SerialName("activity_instances")
    val activityInstances: ActivityInstances?,
    val description: String?,
    @SerialName("verification_level")
    val verificationLevel: Int?,
    @SerialName("premium_subscription_count")
    val premiumSubscriptionCount: Int?,
    val roles: List<Role>?,
    val large: Boolean?,
    @SerialName("application_command_counts")
    val applicationCommandCounts: ApplicationCommandCounts?,
    val presences: List<Presence>?,
    @SerialName("joined_at")
    val joinedAt: String?,
    @SerialName("afk_timeout")
    val afkTimeout: Int?,
    @SerialName("explicit_content_filter")
    val explicitContentFilter: Int?,
    @SerialName("member_count")
    val memberCount: Int?,
    @SerialName("vanity_url_code")
    val vanityUrlCode: String?,
    @SerialName("soundboard_sounds")
    val soundboardSounds: List<SoundboardSound>?,
    val region: String?,
    @SerialName("premium_progress_bar_enabled")
    val premiumProgressBarEnabled: Boolean?,
    @SerialName("discovery_splash")
    val discoverySplash: String?,
    val version: Long?,
    val icon: String?,
    @SerialName("application_id")
    val applicationId: String?,
    @SerialName("max_members")
    val maxMembers: Int?
)