package com.metropolitan.booking.apartment_type;

import java.util.List;

public interface ApartmentTypeService {

    List<ApartmentType> findAllTypes();

    int findApartmentTypeByNaziv(String nazivApartmentType);

    void addApartmentType(ApartmentType apartmentType);

    void deleteApartmentType(ApartmentType apartmentType);

    ApartmentType findByNaziv(String nazivApartmentType);
}
