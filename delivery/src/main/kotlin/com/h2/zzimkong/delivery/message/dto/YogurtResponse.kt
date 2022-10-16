package com.h2.zzimkong.delivery.message.dto

import kotlinx.serialization.Serializable

@Serializable
data class YogurtResponse(
    val id: Long,
    val name: String,
    val type: String,
    val price: Long
)
