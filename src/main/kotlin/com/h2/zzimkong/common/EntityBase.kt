package com.h2.zzimkong.common

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
abstract class EntityBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    lateinit var createdDate: LocalDateTime

    @UpdateTimestamp
    @Column(name = "updated_date")
    lateinit var updatedDate: LocalDateTime
}
