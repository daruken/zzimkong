package com.h2.zzimkong.order.order.domain.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderRequest(
    val memberId: Long,
    val yogurtId: Long,
    val type: String
)
