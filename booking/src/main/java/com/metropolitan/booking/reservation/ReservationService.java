package com.metropolitan.booking.reservation;

import com.metropolitan.booking.customer.Customer;

import java.util.Date;
import java.util.List;

public interface ReservationService {

    List<Reservation> findReservationsByCustomer(Customer customer);

    List<Reservation> findAllReservations();

    void deleteReservation(Reservation reservation);

    void reserveApartment(Reservation reservation);

    public long getDifferenceDays(Date d1, Date d2);

    Reservation findByReservationId(String reservationId);
}
