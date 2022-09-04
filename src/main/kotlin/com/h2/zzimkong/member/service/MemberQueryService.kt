package com.h2.zzimkong.member.service

import com.h2.zzimkong.member.domain.MemberRepository
import com.h2.zzimkong.member.domain.dto.MemberResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberQueryService(
    private val memberRepository: MemberRepository
) {

    suspend fun selectMembers(limit: Long, offset: Long): List<MemberResponse> {
        return memberRepository.findMembers(limit, offset)
    }
}
