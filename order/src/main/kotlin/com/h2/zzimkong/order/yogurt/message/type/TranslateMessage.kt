package com.h2.zzimkong.order.yogurt.message.type

import com.h2.zzimkong.order.yogurt.message.dto.YogurtIdFromDelivery

enum class TranslateMessage {
    ORDER_TO_DELIVERY_ABOUT_YOGURT {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return YogurtIdFromDelivery(data.toLong()) as T
        }
    };

    abstract fun <T> translateMessage(data: String): T
}
