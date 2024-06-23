package com.lcwd.hotel.service.services;

import com.lcwd.hotel.service.entities.Hotel;

import java.util.List;

public interface HotelService {

    // Create
    Hotel createHotel(Hotel hotel);

    // Get all
    List<Hotel> getAllHotels();

    // Get single hotel based on I'd
    Hotel getHotel(String hotelId);

}
