package com.h2.zzimkong.order.yogurt.domain.dto

import com.h2.zzimkong.order.yogurt.domain.type.YogurtType
import kotlinx.serialization.Serializable

@Serializable
data class YogurtResponse(
    val id: Long,
    val name: String,
    val type: YogurtType,
    val price: Long
)
