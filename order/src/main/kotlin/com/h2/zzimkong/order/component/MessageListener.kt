package com.h2.zzimkong.order.component

import com.h2.zzimkong.order.order.message.EventMessage
import com.h2.zzimkong.order.yogurt.domain.dto.YogurtResponse
import com.h2.zzimkong.order.yogurt.message.dto.MessageReceive
import com.h2.zzimkong.order.yogurt.message.dto.YogurtIdFromDelivery
import com.h2.zzimkong.order.yogurt.message.type.TranslateMessage
import com.h2.zzimkong.order.yogurt.service.YogurtQueryService
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class MessageListener(
    private val orderProducer: OrderProducer,
    private val yogurtQueryService: YogurtQueryService
) {
    @KafkaListener(topics = ["yogurt"], groupId = "1000")
    fun receiveMessage(@Payload data: String) {
        executeEvent(Json.decodeFromString(data))
    }

    private fun executeEvent(messageReceive: MessageReceive) {
        when (messageReceive.eventName) {
            TranslateMessage.ORDER_TO_DELIVERY_ABOUT_YOGURT.name -> selectYogurt(
                TranslateMessage.ORDER_TO_DELIVERY_ABOUT_YOGURT.translateMessage(
                    messageReceive.data
                ) as YogurtIdFromDelivery
            )
        }
    }

    private fun selectYogurt(yogurtIdFromDelivery: YogurtIdFromDelivery) {
        runBlocking {
            val yogurtResponse = yogurtQueryService.selectYogurtById(yogurtIdFromDelivery.yogurtId)?.let {
                YogurtResponse(
                    id = it.id!!,
                    name = it.name,
                    type = it.type,
                    price = it.price
                )
            } ?: throw NotFoundException()

            orderProducer.sendEventMessage(EventMessage.YOGURT_TO_DELIVERY.name, Json.encodeToString(yogurtResponse))
        }
    }
}
