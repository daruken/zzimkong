package com.h2.zzimkong.member.domain.dto

import com.querydsl.core.annotations.QueryProjection
import kotlinx.serialization.Serializable

@Serializable
data class MemberResponse @QueryProjection constructor(
    val name: String,
    val email: String
)
