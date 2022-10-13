package com.h2.zzimkong.delivery.delivery.service

import com.h2.zzimkong.delivery.delivery.domain.Delivery
import com.h2.zzimkong.delivery.delivery.domain.DeliveryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DeliveryQueryService(private val deliveryRepository: DeliveryRepository) {
    fun selectDeliveries(): List<Delivery> {
        return deliveryRepository.findAll()
    }
}
