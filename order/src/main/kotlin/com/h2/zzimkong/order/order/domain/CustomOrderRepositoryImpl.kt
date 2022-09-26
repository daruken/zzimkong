package com.h2.zzimkong.order.order.domain

import com.h2.zzimkong.order.order.domain.dto.OrderResponse
import org.springframework.r2dbc.core.DatabaseClient
import reactor.core.publisher.Flux
import java.time.LocalDateTime

class CustomOrderRepositoryImpl(
    private val databaseClient: DatabaseClient
) : CustomOrderRepository {
    override suspend fun findAllOrders(): Flux<OrderResponse> {
        val query =
            "SELECT yo.created_date, yo.id, m.email as memberEmail, m.name as memberName, yo.type, y.name as yogurtName, y.price as yogurtPrice, y.type as yogurtType\n" +
                    "FROM yogurt_order yo\n" +
                    "INNER JOIN member m ON (m.id = yo.member_id)\n" +
                    "INNER JOIN yogurt y ON (y.id = yo.yogurt_id)"

        return databaseClient.sql(query)
            .fetch().all().map {
                OrderResponse(
                    id = it["id"] as Long,
                    memberName = it["memberName"] as String,
                    memberEmail = it["memberEmail"] as String,
                    yogurtName = it["yogurtName"] as String,
                    yogurtType = it["yogurtType"] as String,
                    yogurtPrice = it["yogurtPrice"] as Long,
                    type = it["type"] as String,
                    createdDate = it["created_date"] as LocalDateTime
                )
            }
    }
}
