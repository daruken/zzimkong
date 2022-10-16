package com.h2.zzimkong.delivery.message.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderToDeliveryAboutMember(
    val memberName: String,
    val memberEmail: String
)
