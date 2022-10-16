package com.h2.zzimkong.delivery.component

import com.h2.zzimkong.delivery.delivery.service.DeliveryCommandService
import com.h2.zzimkong.delivery.message.dto.DeliveryFromOrder
import com.h2.zzimkong.delivery.message.dto.MemberResponse
import com.h2.zzimkong.delivery.message.dto.MessageReceive
import com.h2.zzimkong.delivery.message.dto.YogurtResponse
import com.h2.zzimkong.delivery.message.type.TranslateMessage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class MessageListener(
    private val deliveryCommandService: DeliveryCommandService,
    private val deliveryProducer: DeliveryProducer
) {
    @KafkaListener(topics = ["delivery"])
    fun receiveMessage(@Payload data: String) {
        executeEvent(Json.decodeFromString(data))
    }

    private fun executeEvent(messageReceive: MessageReceive) {
        when (messageReceive.eventName) {
            TranslateMessage.DELIVERY_FROM_ORDER.name ->
                sendMemberAndYogurtRequest(
                TranslateMessage.DELIVERY_FROM_ORDER.translateMessage(
                    messageReceive.data
                ) as DeliveryFromOrder
            )

            TranslateMessage.MEMBER_TO_DELIVERY.name -> receiveMemberResponse(
                TranslateMessage.MEMBER_TO_DELIVERY.translateMessage(
                    messageReceive.data
                ) as MemberResponse
            )

            TranslateMessage.YOGURT_TO_DELIVERY.name -> receiveYogurtResponse(
                TranslateMessage.YOGURT_TO_DELIVERY.translateMessage(
                    messageReceive.data
                ) as YogurtResponse
            )
        }
    }

    private fun sendMemberAndYogurtRequest(deliveryFromOrder: DeliveryFromOrder) {
        deliveryProducer.sendEventMessage(
            "member",
            TranslateMessage.ORDER_TO_DELIVERY_ABOUT_MEMBER.name,
            Json.encodeToString(deliveryFromOrder.memberId)
        )

        deliveryProducer.sendEventMessage(
            "yogurt",
            TranslateMessage.ORDER_TO_DELIVERY_ABOUT_YOGURT.name,
            Json.encodeToString(deliveryFromOrder.yogurtId)
        )
    }

    private fun receiveMemberResponse(memberResponse: MemberResponse) {
        println("memberResponse : ${memberResponse}")
    }

    private fun receiveYogurtResponse(yogurtResponse: YogurtResponse) {
        println("yogurtResponse : ${yogurtResponse}")
    }
}
