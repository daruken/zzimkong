package com.h2.zzimkong.member.contoller

import com.h2.zzimkong.member.domain.dto.MemberResponse
import com.h2.zzimkong.member.service.MemberQueryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberQueryService: MemberQueryService
) {
    @QueryMapping("findMembers")
    suspend fun findMembers(@Argument limit: Long, @Argument offset: Long): List<MemberResponse> {
        return withContext(Dispatchers.IO) {
            memberQueryService.selectMembers(limit, offset)
        }.map { MemberResponse(it.name) }.toList()
    }
}
