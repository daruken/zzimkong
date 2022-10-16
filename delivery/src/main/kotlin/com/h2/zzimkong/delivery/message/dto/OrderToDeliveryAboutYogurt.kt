package com.h2.zzimkong.delivery.message.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderToDeliveryAboutYogurt(
    val yogurtName: String,
    val yogurtType: String,
    val yogurtPrice: Long
)
