package com.metropolitan.booking.apartment;

import com.metropolitan.booking.address.Address;
import com.metropolitan.booking.apartment_beds.ApartmentBeds;
import com.metropolitan.booking.apartment_type.ApartmentType;
import com.metropolitan.booking.manager.Manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apartment {

    @Id
    private String apartmentId;

    @DBRef
    private Address address;
    @DBRef
    private Manager manager;
    @DBRef
    private ApartmentBeds apartmentBeds;
    @DBRef
    private ApartmentType apartmentType;

    private String nazivObjekta;
    private double pricePerNight;
}
