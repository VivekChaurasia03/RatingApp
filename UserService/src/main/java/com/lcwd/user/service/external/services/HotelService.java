package com.lcwd.user.service.external.services;

import com.lcwd.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    /*
     * This is a feign Client and SpringBoot will use the below method's details to provide
     * its implementation and that will be called during the runtime. This is what we call
     * as Declarative approach.
     */
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
