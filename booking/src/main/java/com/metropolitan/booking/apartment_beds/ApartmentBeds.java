package com.metropolitan.booking.apartment_beds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentBeds {

    @Id
    private int idApartmentBeds;
    private String naziv;
    private int numberOfBeds;
}
