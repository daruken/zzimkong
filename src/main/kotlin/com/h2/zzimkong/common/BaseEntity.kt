package com.h2.zzimkong.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {
    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    protected lateinit var createdDate: LocalDateTime

    @LastModifiedDate
    @Column(name = "updated_date", nullable = false)
    protected lateinit var updatedDate: LocalDateTime
}