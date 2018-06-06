package me.noy.kotlinspring

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Hotels")
data class Hotel(
        @Id val id: String,
        val name: String,
        @Indexed(direction = IndexDirection.ASCENDING) val price: Double,
        val address: Address,
        val reviews: List<Review>
)

data class Address(private val city: String, private val country: String)
data class Review(private val username: String, private val rating: Double) {
    init {
        if ((rating < 0) || (rating > 10)) {
            throw RatingException("Ratings can only be between 0 and 10")
        }
    }
}

class RatingException(override val message: String) : Throwable()