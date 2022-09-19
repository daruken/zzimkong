package com.h2.zzimkong.order.common

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class EntityBase() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    lateinit var createdDate: LocalDateTime

    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    lateinit var updatedDate: LocalDateTime
}
