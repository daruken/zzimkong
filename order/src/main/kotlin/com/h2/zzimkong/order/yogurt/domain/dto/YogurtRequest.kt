package com.h2.zzimkong.order.yogurt.domain.dto

data class YogurtRequest(
    val name: String,
    val type: String,
    val price: Long
)
