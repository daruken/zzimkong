package com.h2.zzimkong.member.domain

import com.h2.zzimkong.common.EntityBase
import javax.persistence.Entity

@Entity
class Member constructor(
    private val name: String,
    private val password: String
) : EntityBase()
