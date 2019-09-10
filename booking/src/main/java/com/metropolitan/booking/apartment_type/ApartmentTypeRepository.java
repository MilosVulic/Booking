package com.metropolitan.booking.apartment_type;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentTypeRepository extends MongoRepository<ApartmentType, Integer> {

    ApartmentType findByNazivApartmentType(String nazivApartmentType);
}
