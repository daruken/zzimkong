package com.h2.zzimkong.order.order.controller

import com.h2.zzimkong.order.order.domain.Order
import com.h2.zzimkong.order.order.domain.dto.OrderRequest
import com.h2.zzimkong.order.order.domain.dto.OrderResponse
import com.h2.zzimkong.order.order.service.OrderCommandService
import com.h2.zzimkong.order.order.service.OrderQueryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderCommandService: OrderCommandService,
    private val orderQueryService: OrderQueryService
) {
    @QueryMapping("findOrders")
    suspend fun findOrders(): List<OrderResponse>? {
        return withContext(Dispatchers.IO) {
            orderQueryService.selectOrders().collectList().block()?.toList()
        }
    }

    @MutationMapping("createOrder")
    suspend fun createOrder(@Argument(name = "order") orderRequest: OrderRequest): Order {
        return withContext(Dispatchers.IO) {
            orderCommandService.insertOrder(orderRequest)
        }
    }

    @MutationMapping("destroyOrder")
    suspend fun destroyOrder(@Argument(name = "id") id: Long): Boolean {
        return withContext(Dispatchers.IO) {
            orderCommandService.deleteOrder(id)
        }
    }
}
