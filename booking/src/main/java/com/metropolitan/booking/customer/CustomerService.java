package com.metropolitan.booking.customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomerList();

    Customer getCustomerByCredentials(String username, String password);

    void registerCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer getCustomerByUsername(String username);

    Customer findCustomerByCustomerId(String customerId);

    Customer editCustomer(Customer customer, String id);
}
