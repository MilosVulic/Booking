package com.metropolitan.booking.apartment_beds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/apartmentBeds")
public class ApartmentBedsController {

    @Autowired
    private ApartmentBedsService apartmentBedsService;

    @GetMapping(value = "/showAll")
    public List<ApartmentBeds> getAllApartmentBeds() {
        return apartmentBedsService.findAllBeds();
    }
}
