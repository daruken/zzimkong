package com.h2.zzimkong.order.yogurt.service

import com.h2.zzimkong.order.yogurt.domain.Yogurt
import com.h2.zzimkong.order.yogurt.domain.YogurtRepository
import com.h2.zzimkong.order.yogurt.domain.dto.YogurtRequest
import com.h2.zzimkong.order.yogurt.domain.type.YogurtType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class YogurtCommandService(
    private val yogurtRepository: YogurtRepository
) {
    suspend fun insertYogurt(yogurtRequest: YogurtRequest): Yogurt {
        return yogurtRepository.save(
            Yogurt(
                name = yogurtRequest.name,
                type = YogurtType.valueOf(yogurtRequest.type),
                price = yogurtRequest.price
            )
        )
    }

    suspend fun deleteYogurt(id: Long): Boolean {
        yogurtRepository.deleteById(id)
        return true
    }
}
