package com.metropolitan.booking.apartment_beds;

import java.util.List;

public interface ApartmentBedsService {

    List<ApartmentBeds> findAllBeds();

    int findApartmentBedIdByNaziv(String naziv);

    void addApartmentBeds(ApartmentBeds apartmentBeds);

    void deleteApartmentBeds(ApartmentBeds apartmentBeds);

    ApartmentBeds findApartmentBedsByName(String naziv);

}
