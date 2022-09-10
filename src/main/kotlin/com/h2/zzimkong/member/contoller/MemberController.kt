package com.h2.zzimkong.member.contoller

import com.h2.zzimkong.member.domain.dto.MemberResponse
import com.h2.zzimkong.member.service.MemberQueryService
import kotlinx.coroutines.runBlocking
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture

@RestController
class MemberController(
    private val memberService: MemberQueryService
) {
    @Async("asyncExecutor")
    @QueryMapping("findMembers")
    fun findMembers(@Argument limit: Long, @Argument offset: Long): CompletableFuture<List<MemberResponse>> {
        return runBlocking {
            CompletableFuture.completedFuture(memberService.selectMembers(limit, offset))
        }
    }
}
