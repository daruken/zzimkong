package com.h2.zzimkong.member.contoller

import com.h2.zzimkong.member.domain.Member
import com.h2.zzimkong.member.domain.MemberRepository
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberRepository: MemberRepository
) {
    @QueryMapping("findMembers")
    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }
}
