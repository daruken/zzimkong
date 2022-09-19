package com.h2.zzimkong.order.order.domain.dto

import com.h2.zzimkong.order.order.domain.type.OrderType

data class OrderResponse(
    val id: Long,
    val memberId: Long,
    val yogurtId: Long,
    val type: OrderType
)
