package com.metropolitan.booking.apartment_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/apartmentTypes")
public class ApartmentTypeController {

    @Autowired
    private ApartmentTypeService apartmentTypeService;


    @GetMapping(value = "/showAll")
    public List<ApartmentType> getAllApartmentBeds() {
        return apartmentTypeService.findAllTypes();
    }
}
