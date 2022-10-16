package com.h2.zzimkong.delivery.message.dto

import kotlinx.serialization.Serializable

@Serializable
data class DeliveryFromOrder(
    val memberId: Long,
    val yogurtId: Long,
    val type: String
)
