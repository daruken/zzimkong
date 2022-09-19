package com.h2.zzimkong.order.yogurt.domain

import com.h2.zzimkong.order.yogurt.domain.type.YogurtType
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.*

@Table("yogurt")
class Yogurt(
    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    val type: YogurtType,

    @Column(name = "price", nullable = false)
    val price: Long
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0
}
