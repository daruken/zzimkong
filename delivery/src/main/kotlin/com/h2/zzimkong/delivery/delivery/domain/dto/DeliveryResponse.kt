package com.h2.zzimkong.delivery.delivery.domain.dto

import org.bson.types.ObjectId

data class DeliveryResponse(
    val id: String = ObjectId().toString(),
    val memberName: String,
    val memberEmail: String,
    val yogurtName: String,
    val yogurtType: String,
    val yogurtPrice: Long,
    val type: String
)
