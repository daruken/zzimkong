package com.h2.zzimkong.order.order.domain.dto

import java.time.LocalDateTime

data class OrderResponse(
    val id: Long,
    val memberName: String,
    val memberEmail: String? = null,
    val yogurtName: String? = null,
    val yogurtType: String? = null,
    val yogurtPrice: Long? = null,
    val type: String,
    val createdDate: LocalDateTime
)
