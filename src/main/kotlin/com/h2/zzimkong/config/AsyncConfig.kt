package com.h2.zzimkong.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
@EnableAsync
class AsyncConfig(
    @Value("\${sample.pool-size}")
    private val poolSize: Int,
) {
    @Bean(name = ["asyncExecutor"])
    fun taskExecutor(): ThreadPoolTaskExecutor {
        val taskExecutor = ThreadPoolTaskExecutor()
        taskExecutor.setThreadNamePrefix("AsyncThread-")
        taskExecutor.corePoolSize = poolSize
        taskExecutor.maxPoolSize = poolSize * 2
        taskExecutor.queueCapacity = poolSize * 10
        taskExecutor.initialize()
        return taskExecutor
    }
}
