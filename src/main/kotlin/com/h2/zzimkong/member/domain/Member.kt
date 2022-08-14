package com.h2.zzimkong.member.domain

import com.h2.zzimkong.common.EntityBase
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Entity

@Entity
@DynamicInsert
@DynamicUpdate
class Member constructor(
    private val name: String,
    private val password: String
) : EntityBase()
