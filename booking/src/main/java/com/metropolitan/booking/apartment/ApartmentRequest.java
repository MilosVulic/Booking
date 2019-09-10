package com.metropolitan.booking.apartment;

import com.metropolitan.booking.address.Address;
import com.metropolitan.booking.apartment_beds.ApartmentBeds;
import com.metropolitan.booking.apartment_type.ApartmentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentRequest {

    private Address address;
    private String managerId;
    private ApartmentBeds apartmentBeds;
    private ApartmentType apartmentType;
    private String nazivObjekta;
    private double pricePerNight;
}
