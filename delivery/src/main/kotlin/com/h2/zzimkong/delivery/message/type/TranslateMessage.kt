package com.h2.zzimkong.delivery.message.type

import com.h2.zzimkong.delivery.message.dto.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

enum class TranslateMessage {
    MEMBER_TO_DELIVERY {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return Json.decodeFromString<MemberResponse>(data) as T
        }
    },
    YOGURT_TO_DELIVERY {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return Json.decodeFromString<YogurtResponse>(data) as T
        }
    },
    ORDER_TO_DELIVERY_ABOUT_MEMBER {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return Json.decodeFromString<OrderToDeliveryAboutMember>(data) as T
        }
    },
    ORDER_TO_DELIVERY_ABOUT_YOGURT {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return Json.decodeFromString<OrderToDeliveryAboutYogurt>(data) as T
        }
    },
    DELIVERY_FROM_ORDER {
        @Suppress("UNCHECKED_CAST")
        override fun <T> translateMessage(data: String): T {
            return Json.decodeFromString<DeliveryFromOrder>(data) as T
        }
    };

    abstract fun <T> translateMessage(data: String): T
}
