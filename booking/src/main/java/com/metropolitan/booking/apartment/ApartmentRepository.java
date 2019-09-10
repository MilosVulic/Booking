package com.metropolitan.booking.apartment;

import com.metropolitan.booking.manager.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends MongoRepository<Apartment, String> {

    List<Apartment> findApartmentsByManager(Manager manager);

    Apartment findApartmentBy(String apartmentId);

}
