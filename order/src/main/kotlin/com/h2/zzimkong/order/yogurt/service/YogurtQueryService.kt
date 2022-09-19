package com.h2.zzimkong.order.yogurt.service

import com.h2.zzimkong.order.yogurt.domain.Yogurt
import com.h2.zzimkong.order.yogurt.domain.YogurtRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class YogurtQueryService(
    private val yogurtRepository: YogurtRepository
) {
    suspend fun selectYogurts(): Flow<Yogurt> {
        return yogurtRepository.findAll()
    }
}