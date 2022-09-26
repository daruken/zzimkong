package com.h2.zzimkong.order.order.domain

import com.h2.zzimkong.order.order.domain.type.OrderType
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import javax.persistence.Column
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
    var id: Long? = null

    @Column(name = "created_date", nullable = false, updatable = false)
    val createdDate: LocalDateTime = LocalDateTime.now()
}
