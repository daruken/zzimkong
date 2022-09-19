package com.h2.zzimkong.order.order.service

import com.h2.zzimkong.order.order.domain.Order
import com.h2.zzimkong.order.order.domain.OrderRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderQueryService(
    private val orderRepository: OrderRepository
) {
    suspend fun selectOrders(): Flow<Order> {
        return orderRepository.findAll()
    }
}
