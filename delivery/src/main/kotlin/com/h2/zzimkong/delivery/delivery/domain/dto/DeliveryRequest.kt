package com.h2.zzimkong.delivery.delivery.domain.dto

data class DeliveryRequest(
    val memberName: String,
    val memberEmail: String,
    val yogurtName: String,
    val yogurtType: String,
    val yogurtPrice: Long,
    val type: String
)
