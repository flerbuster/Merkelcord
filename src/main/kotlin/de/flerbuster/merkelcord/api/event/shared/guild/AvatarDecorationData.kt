package de.flerbuster.merkelcord.api.event.shared.guild


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AvatarDecorationData(
    @SerialName("sku_id")
    val skuId: String,
    val asset: String
)