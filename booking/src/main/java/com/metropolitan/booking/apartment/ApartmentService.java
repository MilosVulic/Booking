package com.metropolitan.booking.apartment;

import com.metropolitan.booking.manager.Manager;

import java.util.List;

public interface ApartmentService {

    List<Apartment> getApartmentsByMnaager(Manager manager);

    List<Apartment> getAllApartments();

    void addApartment(Apartment apartment);

    void removeApapartment(Apartment apartment);

    Apartment getApartmentById(String apartmentId);
}
