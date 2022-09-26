package com.h2.zzimkong.order.order.service

import com.h2.zzimkong.order.order.domain.OrderRepository
import com.h2.zzimkong.order.order.domain.dto.OrderResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux

@Service
@Transactional(readOnly = true)
class OrderQueryService(
    private val orderRepository: OrderRepository
) {
    suspend fun selectOrders(): Flux<OrderResponse> {
        return orderRepository.findAllOrders()
    }
}
