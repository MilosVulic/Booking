package com.metropolitan.booking.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByUsernameAndPassword(String username, String password);

    Customer findCustomerByUsername(String username);

    Customer findCustomerByCustomerId(String customerId);
}
