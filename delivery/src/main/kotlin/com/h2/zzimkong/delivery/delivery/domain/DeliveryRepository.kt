package com.h2.zzimkong.delivery.delivery.domain

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DeliveryRepository : MongoRepository<Delivery, String> {
}
