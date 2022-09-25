package com.h2.zzimkong.order.order.domain

import com.h2.zzimkong.order.order.domain.dto.OrderResponse
import reactor.core.publisher.Flux

interface CustomOrderRepository {
    suspend fun findAllOrders(): Flux<OrderResponse>
}