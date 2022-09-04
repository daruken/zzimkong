package com.h2.zzimkong.member.contoller

import com.h2.zzimkong.member.domain.dto.MemberResponse
import com.h2.zzimkong.member.service.MemberQueryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.slf4j.MDCContext
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberService: MemberQueryService
) {
    @QueryMapping("findMembers")
    fun findMembers(@Argument limit: Long, @Argument offset: Long): List<MemberResponse> {
        return runBlocking(Dispatchers.IO + MDCContext()) {
            val result = async { memberService.selectMembers(limit, offset) }
            result.await()
        }
    }
}
