package com.h2.zzimkong.member.domain

import com.h2.zzimkong.common.EntityBase
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Member constructor(
    @Column(nullable = false)
    private val name: String,
    @Column(nullable = false)
    private val password: String,
    @Column(nullable = false)
    private val email: String
) : EntityBase()
