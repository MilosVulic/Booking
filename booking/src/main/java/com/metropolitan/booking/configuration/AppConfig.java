package com.metropolitan.booking.configuration;

import com.metropolitan.booking.apartment.Apartment;
import com.metropolitan.booking.apartment.ApartmentService;
import com.metropolitan.booking.apartment_beds.ApartmentBeds;
import com.metropolitan.booking.apartment_beds.ApartmentBedsService;
import com.metropolitan.booking.apartment_type.ApartmentType;
import com.metropolitan.booking.apartment_type.ApartmentTypeService;
import com.metropolitan.booking.customer.Customer;
import com.metropolitan.booking.customer.CustomerService;
import com.metropolitan.booking.reservation.Reservation;
import com.metropolitan.booking.reservation.ReservationService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ApplicationRunner setUp(CustomerService customerService, ApartmentBedsService apartmentBedsService,
                                   ApartmentTypeService apartmentTypeService, ApartmentService apartmentService, ReservationService reservationService) {
        return args -> {


            for (ApartmentBeds ab : apartmentBedsService.findAllBeds()) {
                apartmentBedsService.deleteApartmentBeds(ab);
            }

            for (Apartment apart : apartmentService.getAllApartments()) {
                apartmentService.removeApapartment(apart);
            }

            for (Reservation res : reservationService.findAllReservations()) {
                reservationService.deleteReservation(res);
            }

            for (ApartmentType at : apartmentTypeService.findAllTypes()) {
                apartmentTypeService.deleteApartmentType(at);
            }

            ApartmentBeds a1 = new ApartmentBeds(1, "One bed", 1);
            ApartmentBeds a2 = new ApartmentBeds(2, "Two beds", 2);
            ApartmentBeds a3 = new ApartmentBeds(3, "Three beds", 3);

            ApartmentType at1 = new ApartmentType(1, "Single room");
            ApartmentType at2 = new ApartmentType(2, "Duplex");
            ApartmentType at3 = new ApartmentType(3, "Triplex");
            ApartmentType at4 = new ApartmentType(4, "Studio");
            ApartmentType at5 = new ApartmentType(5, "Loft");
            ApartmentType at6 = new ApartmentType(6, "Guarden apartment");

            apartmentBedsService.addApartmentBeds(a1);
            apartmentBedsService.addApartmentBeds(a2);
            apartmentBedsService.addApartmentBeds(a3);

            apartmentTypeService.addApartmentType(at1);
            apartmentTypeService.addApartmentType(at2);
            apartmentTypeService.addApartmentType(at3);
            apartmentTypeService.addApartmentType(at4);
            apartmentTypeService.addApartmentType(at5);
            apartmentTypeService.addApartmentType(at6);

            for (Customer customer : customerService.getCustomerList()) {
                System.out.println(customer);
            }

            System.out.println();
            customerService.deleteCustomer(customerService.getCustomerByCredentials("username3", "password3"));

            for (Customer customer : customerService.getCustomerList()) {
                System.out.println(customer);
            }
        };
    }
}
