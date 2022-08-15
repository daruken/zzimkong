package com.h2.zzimkong.member.domain

import com.h2.zzimkong.common.EntityBase
import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Entity

@Document(collection = "member")
@Entity
class Member constructor(
    private val name: String,
    private val password: String
) : EntityBase()
