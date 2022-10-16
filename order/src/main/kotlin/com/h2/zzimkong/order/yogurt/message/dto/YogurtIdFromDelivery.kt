package com.h2.zzimkong.order.yogurt.message.dto

import kotlinx.serialization.Serializable

@Serializable
data class YogurtIdFromDelivery(
    val yogurtId: Long
)
