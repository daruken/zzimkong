package com.h2.zzimkong.member.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : CoroutineCrudRepository<Member, Long> {
}
