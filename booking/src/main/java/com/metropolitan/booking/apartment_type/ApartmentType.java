package com.metropolitan.booking.apartment_type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentType {

    @Id
    private int idApartmentType;
    private String nazivApartmentType;
}
