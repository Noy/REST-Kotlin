package me.noy.kotlinspring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController {

    @Autowired private lateinit var hotelRepository: HotelRepository

    @GetMapping("all")
    fun getAllHotels(): List<Hotel> = this.hotelRepository.findAll()

    @PutMapping
    fun insert(@RequestBody hotel: Hotel): Hotel = this.hotelRepository.insert(hotel)

    @PostMapping
    fun update(@RequestBody hotel: Hotel): Hotel = this.hotelRepository.save(hotel)

    @DeleteMapping
    fun delete(@PathVariable("id") id: String): Unit = this.hotelRepository.deleteById(id)

    @GetMapping("/{id}")
    fun getHotelById(@PathVariable("id") id: String): Hotel = this.hotelRepository.findHotelById(id)

    @GetMapping("/price/{maxPrice}")
    fun getPricePerNight(@PathVariable("maxPrice") maxPrice: Double): List<Hotel> =  this.hotelRepository.findHotelByPriceLessThan(maxPrice)

    @GetMapping("/address/{city}")
    fun getByCity(@PathVariable("city") city: String): List<Hotel> = this.hotelRepository.findHotelByCity(city)
}