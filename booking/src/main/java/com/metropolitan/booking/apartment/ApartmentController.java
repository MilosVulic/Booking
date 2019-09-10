package com.metropolitan.booking.apartment;

import com.metropolitan.booking.address.Address;
import com.metropolitan.booking.address.AddressService;
import com.metropolitan.booking.apartment_beds.ApartmentBedsService;
import com.metropolitan.booking.apartment_type.ApartmentTypeService;
import com.metropolitan.booking.configuration.Id;
import com.metropolitan.booking.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/apartment")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private AddressService addressService;

    private ManagerService managerService;

    @Autowired
    private ApartmentTypeService apartmentTypeService;

    @Autowired
    private ApartmentBedsService apartmentBedsService;

    @Autowired
    public ApartmentController(ManagerService managerService1) {
        this.managerService = managerService1;
    }

    @PostMapping(value = "/add")
    public void createApartment(@RequestBody ApartmentRequest apartmentRequest) {
        Address a = new Address(Id.generate(), apartmentRequest.getAddress().getCountry(), apartmentRequest.getAddress().getCity(), apartmentRequest.getAddress().getStreetAddress());
        addressService.addAddress(a);

        apartmentService.addApartment(new Apartment(Id.generate(), a, managerService.findByManagerId(apartmentRequest.getManagerId()),
                apartmentBedsService.findApartmentBedsByName(apartmentRequest.getApartmentBeds().getNaziv()),
                apartmentTypeService.findByNaziv(apartmentRequest.getApartmentType().getNazivApartmentType()),
                apartmentRequest.getNazivObjekta(), apartmentRequest.getPricePerNight()
        ));
    }

    @GetMapping(value = "/showAll")
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/showAll/{id}")
    public List<Apartment> getAllApartments(@PathVariable String id) {
        List<Apartment> lis = apartmentService.getApartmentsByMnaager(managerService.findByManagerId(id));
        return apartmentService.getApartmentsByMnaager(managerService.findByManagerId(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApartment(@PathVariable String id) {
        apartmentService.removeApapartment(apartmentService.getApartmentById(id));
    }
}
