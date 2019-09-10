package com.metropolitan.booking.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Customer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByCredentials(String username, String password) {
        return customerRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void registerCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.insert(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        if (customer != null) {
            customerRepository.delete(customer);
        }
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

    @Override
    public Customer findCustomerByCustomerId(String customerId) {
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    @Override
    public Customer editCustomer(Customer customer, String id) {
        Customer c = customerRepository.findCustomerByCustomerId(id);
        c.setPassword(passwordEncoder.encode(customer.getPassword()));
        c.setEmail(customer.getEmail());
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setUsername(customer.getUsername());
        c.setPhoneNumber(customer.getPhoneNumber());
        return c;
    }
}
