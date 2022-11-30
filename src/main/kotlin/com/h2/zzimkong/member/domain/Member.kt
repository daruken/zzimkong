package com.h2.zzimkong.member.domain

import com.h2.zzimkong.common.BaseEntity
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*

@Table("member")
@Entity
class Member(
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "email", nullable = false)
    val email: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
}
