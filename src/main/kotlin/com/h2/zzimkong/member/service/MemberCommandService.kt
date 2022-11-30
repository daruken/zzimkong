package com.h2.zzimkong.member.service

import com.h2.zzimkong.member.domain.MemberRepository
import com.h2.zzimkong.member.domain.dto.MemberMapper
import com.h2.zzimkong.member.domain.dto.MemberRequest
import com.h2.zzimkong.member.domain.dto.MemberResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberCommandService(
    private val memberMapper: MemberMapper,
    private val memberRepository: MemberRepository
) {
    suspend fun insertMember(memberRequest: MemberRequest): MemberResponse {
        return memberMapper.toDto(memberRepository.save(memberMapper.toEntity(memberRequest)))
    }
}
