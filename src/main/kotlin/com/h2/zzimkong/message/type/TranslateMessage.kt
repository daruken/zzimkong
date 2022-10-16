package com.h2.zzimkong.message.type

import com.h2.zzimkong.message.dto.MemberIdFromDelivery

enum class TranslateMessage {
    ORDER_TO_DELIVERY_ABOUT_MEMBER {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return MemberIdFromDelivery(data.toLong()) as T
        }
    };

    abstract fun <T> translateMessage(data: String): T
}
