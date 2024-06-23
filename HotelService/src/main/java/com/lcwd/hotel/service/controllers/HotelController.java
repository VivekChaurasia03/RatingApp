package com.lcwd.hotel.service.controllers;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel hotelCreated = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelCreated);
    }


    // Get single hotel based on I'd
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) {
        Hotel hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    // Get all Hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> listOfHotels = hotelService.getAllHotels();
        return ResponseEntity.ok(listOfHotels);
    }
}
