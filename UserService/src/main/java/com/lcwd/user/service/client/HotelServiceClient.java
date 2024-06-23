package com.lcwd.user.service.client;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.external.services.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelServiceClient {

    private Logger log = LoggerFactory.getLogger(HotelServiceClient.class);

    // private final RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    /*
    @Autowired
    public HotelServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Hotel getHotelById(String hotelId) {
        ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + hotelId, Hotel.class);
        log.info("Response status code: {}", responseEntity.getStatusCode());
        return responseEntity.getBody();
    }
    */

    public Hotel getHotelById(String hotelId) {
        return hotelService.getHotelById(hotelId);
    }
}
