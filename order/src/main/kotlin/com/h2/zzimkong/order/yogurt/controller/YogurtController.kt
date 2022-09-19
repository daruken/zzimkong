package com.h2.zzimkong.order.yogurt.controller

import com.h2.zzimkong.order.yogurt.domain.Yogurt
import com.h2.zzimkong.order.yogurt.domain.dto.YogurtRequest
import com.h2.zzimkong.order.yogurt.domain.dto.YogurtResponse
import com.h2.zzimkong.order.yogurt.service.YogurtCommandService
import com.h2.zzimkong.order.yogurt.service.YogurtQueryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class YogurtController(
    private val yogurtCommandService: YogurtCommandService,
    private val yogurtQueryService: YogurtQueryService
) {
    @QueryMapping("findYogurts")
    suspend fun findYogurts(): List<YogurtResponse> {
        return withContext(Dispatchers.IO) {
            yogurtQueryService.selectYogurts()
        }.map { YogurtResponse(it.id!!, it.name, it.type, it.price) }.toList()
    }

    @MutationMapping("createYogurt")
    suspend fun createYogurt(@Argument(name = "yogurt") yogurtRequest: YogurtRequest): Yogurt {
        return withContext(Dispatchers.IO) {
            yogurtCommandService.insertYogurt(yogurtRequest)
        }
    }

    @MutationMapping("destroyYogurt")
    suspend fun destroyYogurt(@Argument id: Long): Boolean {
        return withContext(Dispatchers.IO) {
            yogurtCommandService.deleteYogurt(id)
        }
    }
}
