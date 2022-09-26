package com.h2.zzimkong.order.order.service

import com.h2.zzimkong.order.component.OrderProducer
import com.h2.zzimkong.order.order.domain.Order
import com.h2.zzimkong.order.order.domain.OrderRepository
import com.h2.zzimkong.order.order.domain.dto.OrderRequest
import com.h2.zzimkong.order.order.domain.type.OrderType
import com.h2.zzimkong.order.order.message.EventMessage
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCommandService(
    private val orderProducer: OrderProducer,
    private val orderRepository: OrderRepository
) {
    suspend fun insertOrder(orderRequest: OrderRequest): Order {
        val order = orderRepository.save(
            Order(
                memberId = orderRequest.memberId,
                yogurtId = orderRequest.yogurtId,
                type = OrderType.valueOf(orderRequest.type)
            )
        )

        orderProducer.sendEventMessage(EventMessage.DELIVERY_FROM_ORDER.name, Json.encodeToString(orderRequest))
        return order
    }

    suspend fun deleteOrder(id: Long): Boolean {
        orderRepository.deleteById(id)
        return true
    }
}
