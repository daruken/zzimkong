package com.h2.zzimkong.order.component

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaProducerException
import org.springframework.kafka.core.KafkaSendCallback
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component

@Component
class OrderProducer(
    val kafkaTemplate: KafkaTemplate<String, String>
) {
    @Value("\${kafka.topic}")
    lateinit var topic: String

    fun sendMessage(message: String) {
        kafkaTemplate.send(topic, message).addCallback(listenableFutureCallback(message))
    }

    fun listenableFutureCallback(message: String) =
        object: KafkaSendCallback<String, String> {
            override fun onSuccess(result: SendResult<String, String>?) {
                println(
                    "Send Message = [ $message ] with offset=[ ${result!!.recordMetadata.offset()} ]"
                )
            }

            override fun onFailure(ex: KafkaProducerException) {
                println(
                    "Message 전달 오류 [ $message ] due to: ${ex.getFailedProducerRecord<String, String>()}"
                )
            }
        }
}
