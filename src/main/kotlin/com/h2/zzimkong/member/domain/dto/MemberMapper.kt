package com.h2.zzimkong.member.domain.dto

import com.h2.zzimkong.member.domain.Member
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
interface MemberMapper {
    fun toEntity(memberRequest: MemberRequest): Member

    fun toDto(member: Member): MemberResponse
}
