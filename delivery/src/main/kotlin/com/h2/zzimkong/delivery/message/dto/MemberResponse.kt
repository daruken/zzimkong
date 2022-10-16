package com.h2.zzimkong.delivery.message.dto

import kotlinx.serialization.Serializable

@Serializable
data class MemberResponse(
    val name: String,
    val email: String
)
