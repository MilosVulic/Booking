package com.metropolitan.booking.address;

import com.metropolitan.booking.configuration.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/add")
    public void createAddress(@RequestBody Address address) {
        addressService.addAddress(new Address(Id.generate(), address.getCountry(), address.getCity(), address.getStreetAddress()));
    }

    @GetMapping(value = "/showAll")
    public List<Address> getAllAddresses() {
        return addressService.showAllAddresses();
    }
}
