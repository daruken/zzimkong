package com.h2.zzimkong.order.order.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
interface OrderRepository : CoroutineCrudRepository<Order, Long>, CustomOrderRepository {
    override suspend fun deleteById(id: Long)
}
