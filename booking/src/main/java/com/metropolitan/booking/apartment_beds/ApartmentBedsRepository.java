package com.metropolitan.booking.apartment_beds;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentBedsRepository extends MongoRepository<ApartmentBeds, Integer> {

    ApartmentBeds findByNaziv(String naziv);
}
