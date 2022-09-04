package com.h2.zzimkong.member.domain

import com.h2.zzimkong.member.domain.QMember.member
import com.h2.zzimkong.member.domain.dto.MemberResponse
import com.h2.zzimkong.member.domain.dto.QMemberResponse
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport


class CustomMemberRepositoryImpl : QuerydslRepositorySupport(Member::class.java), CustomMemberRepository {
    override suspend fun findMembers(limit: Long, offset: Long): List<MemberResponse> {
        return from(member)
            .limit(limit)
            .offset(offset)
            .select(QMemberResponse(member.name))
            .fetch()
    }
}
