package com.h2.zzimkong.member.domain.dto

import com.querydsl.core.annotations.QueryProjection

data class MemberResponse @QueryProjection constructor(
    val name: String
)
