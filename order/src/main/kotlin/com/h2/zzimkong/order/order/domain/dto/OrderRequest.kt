package com.h2.zzimkong.order.order.domain.dto

data class OrderRequest(
    val memberId: Long,
    val yogurtId: Long,
    val type: String
)
