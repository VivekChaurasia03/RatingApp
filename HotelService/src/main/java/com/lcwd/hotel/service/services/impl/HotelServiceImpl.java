package com.lcwd.hotel.service.services.impl;

import com.lcwd.hotel.service.entities.Hotel;
import com.lcwd.hotel.service.exceptions.ResourceNotFoundException;
import com.lcwd.hotel.service.repositories.HotelRepository;
import com.lcwd.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("The Hotel that you are looking for doesnt exits. Hotel I'd: " + hotelId));
    }
}
