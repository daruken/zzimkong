package com.h2.zzimkong.member.domain

import com.h2.zzimkong.common.EntityBase
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Column
import javax.persistence.Entity

@Table("member")
@Entity
class Member(
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "email", nullable = false)
    val email: String
) : EntityBase()
