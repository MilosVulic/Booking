package com.metropolitan.booking.reservation;

import com.metropolitan.booking.customer.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {

    List<Reservation> findByCustomer(Customer customer);

    Reservation findByReservationId(String reservationId);
}
