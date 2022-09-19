package com.h2.zzimkong.order.yogurt.domain.dto

import com.h2.zzimkong.order.yogurt.domain.type.YogurtType

data class YogurtResponse(
    val id: Long,
    val name: String,
    val type: YogurtType,
    val price: Long
)
