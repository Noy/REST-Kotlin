package me.noy.kotlinspring

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
open class DBImpl(private val hotelRepository: HotelRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val hilton = Hotel("1", "Hilton", 200.0,
                Address("Las Vegas", "US"),
                arrayListOf(Review("jason", 8.2)))

        val marriott = Hotel("2", "Marriott", 100.0,
                Address("Jacksonville", "US"),
                arrayListOf(Review("monroe", 9.5)))

        val ramada = Hotel("3", "Ramada", 90.0,
                Address("London", "UK"),
                arrayListOf(Review("farmer john", 9.5)))

        // drop existing (for demo)
        this.hotelRepository.deleteAll()

        // let's add
        val hotels: MutableList<Hotel> = mutableListOf(hilton, marriott, ramada)
        this.hotelRepository.saveAll(hotels)
    }

}