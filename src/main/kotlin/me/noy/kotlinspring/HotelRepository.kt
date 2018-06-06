package me.noy.kotlinspring

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface HotelRepository : MongoRepository<Hotel, String> {
    fun findHotelById(id: String): Hotel
    fun findHotelByPriceLessThan(price: Double): List<Hotel>

    @Query(value = "{'address.city':?0}")
    fun findHotelByCity(city: String): List<Hotel>
}