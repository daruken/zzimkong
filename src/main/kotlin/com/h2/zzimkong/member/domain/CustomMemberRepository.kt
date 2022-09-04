package com.h2.zzimkong.member.domain

import com.h2.zzimkong.member.domain.dto.MemberResponse

interface CustomMemberRepository {
    fun findMembers(limit: Long, offset: Long): List<MemberResponse>
}
