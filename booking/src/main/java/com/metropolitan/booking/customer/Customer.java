package com.metropolitan.booking.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String customerId;

    private String nazivRole;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public Customer(String customerId, String email, String username, String password, String firstName, String lastName, int phoneNumber) {

        this.customerId = customerId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

        for (Rola rolica : Rola.values()) {
            if (rolica.getIme().equals("Customer")) {
                this.nazivRole = rolica.getIme();
            }
        }
    }
}
