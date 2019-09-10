package com.metropolitan.booking.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String idAddress;
    private String country;
    private String city;
    private String streetAddress;
}
