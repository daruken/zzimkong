package com.h2.zzimkong.order.order.service

import com.h2.zzimkong.order.order.domain.Order
import com.h2.zzimkong.order.order.domain.OrderRepository
import com.h2.zzimkong.order.order.domain.dto.OrderRequest
import com.h2.zzimkong.order.order.domain.type.OrderType
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCommandService(
    private val orderRepository: OrderRepository
) {
    suspend fun insertOrder(orderRequest: OrderRequest): Order {
        return orderRepository.save(
            Order(
                memberId = orderRequest.memberId,
                yogurtId = orderRequest.yogurtId,
                type = OrderType.valueOf(orderRequest.type)
            )
        )
    }

    suspend fun deleteOrder(id: Long): Boolean {
        orderRepository.deleteById(id)
        return true
    }
}
