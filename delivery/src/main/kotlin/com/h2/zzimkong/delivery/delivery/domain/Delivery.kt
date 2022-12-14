package com.h2.zzimkong.delivery.delivery.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("delivery")
data class Delivery(
    val memberName: String,
    val memberEmail: String,
    val yogurtName: String,
    val yogurtType: String,
    val yogurtPrice: Long,
    val type: String
) {
    @Id
    var id: String = ObjectId().toString()
}
