package com.h2.zzimkong.order.order.domain

import com.h2.zzimkong.order.order.domain.type.OrderType
import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.relational.core.mapping.Table
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Table("yogurt_order")
class Order(
    @Column(name = "member_id", nullable = false)
    val memberId: Long,

    @Column(name = "yogurt_id", nullable = false)
    val yogurtId: Long,

    @Column(name = "type", nullable = false)
    val type: OrderType
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = 0

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    var createdDate: LocalDateTime = LocalDateTime.now()
}
