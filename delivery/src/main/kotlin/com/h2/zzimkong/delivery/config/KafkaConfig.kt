package com.h2.zzimkong.delivery.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import java.net.InetAddress
import java.net.UnknownHostException
import java.util.*

@EnableKafka
@Configuration
class KafkaConfig {
    @Value("\${kafka.host}")
    lateinit var host: String

    @Value("\${kafka.topic}")
    lateinit var topic: String

    @Value("\${kafka.groupId}")
    lateinit var groupId: String

    @Primary
    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val containerFactory = ConcurrentKafkaListenerContainerFactory<String, String>()
        containerFactory.consumerFactory = consumerFactory()
        return containerFactory
    }

    @Primary
    @Bean
    fun consumerFactory(): ConsumerFactory<in String, in String> {
        return DefaultKafkaConsumerFactory(consumerProperties())
    }

    @Bean
    fun consumerProperties(): Map<String, Any> {
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
