package com.h2.zzimkong.order.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import java.io.Serializable
import java.net.InetAddress
import java.net.UnknownHostException
import java.util.*

@Configuration
class KafkaConfig {
    @Value("\${kafka.host}")
    lateinit var host: String

    @Value("\${kafka.topic}")
    lateinit var topic: String

    @Value("\${kafka.groupId}")
    lateinit var groupId: String

    @Bean
    fun producerConfigs(): Map<String, Serializable> =  mapOf(
            ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to host,
            ConsumerConfig.GROUP_ID_CONFIG to groupId,
            ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java,
            ProducerConfig.MAX_BLOCK_MS_CONFIG to 2000
        )

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        val factory = DefaultKafkaProducerFactory<String, String>(producerConfigs())
        return KafkaTemplate(factory)
    }

    @Bean
    fun consumerProperties(): Map<String, Any> {
        val hostName = try {
            InetAddress.getLocalHost().hostName + UUID.randomUUID().toString()
        } catch (e: UnknownHostException) {
            UUID.randomUUID().toString()
        }

        return hashMapOf(
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to host,
            ConsumerConfig.GROUP_ID_CONFIG to groupId,
            ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG to "true",
            ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to "latest",
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java
        )
    }
}
