package com.metropolitan.booking.reservation;

import com.metropolitan.booking.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


    @Override
    public List<Reservation> findReservationsByCustomer(Customer customer) {
        return reservationRepository.findByCustomer(customer);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public void reserveApartment(Reservation reservation) {
        reservationRepository.insert(reservation);
    }

    @Override
    public long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public Reservation findByReservationId(String reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }
}
