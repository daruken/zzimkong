package com.h2.zzimkong.delivery.component

import org.json.simple.JSONObject
import org.springframework.kafka.core.KafkaProducerException
import org.springframework.kafka.core.KafkaSendCallback
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component

@Component
class DeliveryProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun sendEventMessage(topic: String, eventName: String, obj: Any) {
        val jsonObject = JSONObject()
        jsonObject["eventName"] = eventName
        jsonObject["data"] = obj
        val message = jsonObject.toString()

        kafkaTemplate.send(topic, message).addCallback(listenableFutureCallback(message))
    }

    fun listenableFutureCallback(message: String) =
        object : KafkaSendCallback<String, String> {
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
