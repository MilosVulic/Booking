package com.metropolitan.booking.reservation;

import com.metropolitan.booking.apartment.Apartment;
import com.metropolitan.booking.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    private String reservationId;

    @DBRef
    private Apartment apartment;

    @DBRef
    private Customer customer;

    private Date datumPocetka;
    private Date datumIsteka;
    private double ukupnaCena;
}
