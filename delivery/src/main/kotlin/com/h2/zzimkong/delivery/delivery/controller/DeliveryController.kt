package com.h2.zzimkong.delivery.delivery.controller

import com.h2.zzimkong.delivery.delivery.domain.dto.DeliveryResponse
import com.h2.zzimkong.delivery.delivery.service.DeliveryQueryService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DeliveryController(
    private val deliveryQueryService: DeliveryQueryService
) {
    @QueryMapping("findDeliveries")
    fun findDeliveries(): List<DeliveryResponse> {
        return deliveryQueryService.selectDeliveries().map {
            DeliveryResponse(
                id = it.id,
                memberName = it.memberName,
                memberEmail = it.memberEmail,
                yogurtName = it.yogurtName,
                yogurtType = it.yogurtType,
                yogurtPrice = it.yogurtPrice,
                type = it.type
            )
        }
    }
}
