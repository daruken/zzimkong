package com.h2.zzimkong.member.service

import com.h2.zzimkong.member.domain.Member
import com.h2.zzimkong.member.domain.MemberRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberQueryService(
    private val memberRepository: MemberRepository
) {
    suspend fun selectMembers(limit: Long, offset: Long): Flow<Member> {
        return memberRepository.findAll()
    }

    suspend fun selectMemberById(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}
