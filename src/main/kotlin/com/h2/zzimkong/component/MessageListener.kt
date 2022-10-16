package com.h2.zzimkong.component

import com.h2.zzimkong.member.domain.dto.MemberResponse
import com.h2.zzimkong.member.service.MemberQueryService
import com.h2.zzimkong.message.EventMessage
import com.h2.zzimkong.message.dto.MemberIdFromDelivery
import com.h2.zzimkong.message.dto.MessageReceive
import com.h2.zzimkong.message.type.TranslateMessage
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class MessageListener(
    private val memberProducer: MemberProducer,
    private val memberQueryService: MemberQueryService
) {
    @KafkaListener(topics = ["member"], groupId = "1357")
    fun receiveMessage(@Payload data: String) {
        executeEvent(Json.decodeFromString(data))
    }

    private fun executeEvent(messageReceive: MessageReceive) {
        when (messageReceive.eventName) {
            TranslateMessage.ORDER_TO_DELIVERY_ABOUT_MEMBER.name -> selectMember(
                TranslateMessage.ORDER_TO_DELIVERY_ABOUT_MEMBER.translateMessage(
                    messageReceive.data
                ) as MemberIdFromDelivery
            )
        }
    }

    private fun selectMember(memberIdFromDelivery: MemberIdFromDelivery) {
        runBlocking {
            val memberResponse = memberQueryService.selectMemberById(memberIdFromDelivery.memberId)?.let {
                MemberResponse(
                    name = it.name,
                    email = it.email
                )
            } ?: throw ChangeSetPersister.NotFoundException()

            memberProducer.sendEventMessage("delivery", EventMessage.MEMBER_TO_DELIVERY.name, Json.encodeToString(memberResponse))
        }
    }
}
