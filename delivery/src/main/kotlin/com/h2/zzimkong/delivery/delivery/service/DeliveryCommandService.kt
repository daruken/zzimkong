package com.h2.zzimkong.delivery.delivery.service

import com.h2.zzimkong.delivery.delivery.domain.Delivery
import com.h2.zzimkong.delivery.delivery.domain.DeliveryRepository
import com.h2.zzimkong.delivery.delivery.domain.dto.DeliveryRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class DeliveryCommandService(
    private val deliveryRepository: DeliveryRepository
) {
    fun insertDelivery(deliveryRequest: DeliveryRequest): Delivery {
        return deliveryRepository.save(
            Delivery(
                memberName = deliveryRequest.memberName,
                memberEmail = deliveryRequest.memberEmail,
                yogurtName = deliveryRequest.yogurtName,
                yogurtType = deliveryRequest.yogurtType,
                yogurtPrice = deliveryRequest.yogurtPrice,
                type = deliveryRequest.type
            )
        )
    }
}
