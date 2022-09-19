package com.h2.zzimkong.order.yogurt.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface YogurtRepository : CoroutineCrudRepository<Yogurt, Long> {
    override suspend fun deleteById(id: Long)
}
