package com.h2.zzimkong.delivery.example

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class TestKafka {
    @KafkaListener(topics = ["zzimkong"])
    fun consume(@Payload data: String) {
        println("Message : $data")
    }
}
