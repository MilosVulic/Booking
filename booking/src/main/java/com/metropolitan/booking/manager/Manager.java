package com.metropolitan.booking.manager;


import com.metropolitan.booking.customer.Rola;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    @Id
    private String managerId;

    private String nazivRole;
    private String ppUsername;
    private String ppPassword;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int phoneNumber;


    public Manager(String managerId, String ppUsername, String ppPassword, String username, String password, String firstName, String lastName, int phoneNumber) {

        this.managerId = managerId;
        this.ppPassword = ppPassword;
        this.ppUsername = ppUsername;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;

        for (Rola rolica : Rola.values()) {
            if (rolica.getIme().equals("Manager")) {
                this.nazivRole = rolica.getIme();
            }
        }
    }
}
