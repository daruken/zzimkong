package com.h2.zzimkong.order.order.service

import com.h2.zzimkong.order.component.OrderProducer
import com.h2.zzimkong.order.order.domain.Order
import com.h2.zzimkong.order.order.domain.OrderRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.kafka.support.SendResult
import org.springframework.lang.Nullable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback

@Service
@Transactional(readOnly = true)
class OrderQueryService(
    private val orderProducer: OrderProducer,
    private val orderRepository: OrderRepository
) {
    suspend fun selectOrders(): Flow<Order> {
        orderProducer.sendMessage("Send to test Message")

        return orderRepository.findAll()
    }
}

