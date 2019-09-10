package com.metropolitan.booking.customer;

import com.metropolitan.booking.configuration.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/showAll")
    public List<Customer> getAllCustomers() {
        return customerService.getCustomerList();
    }

    @PostMapping(value = "/add")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(new Customer(Id.generate(), customer.getEmail(), customer.getUsername(), customer.getPassword(),
                customer.getFirstName(), customer.getLastName(), customer.getPhoneNumber()));
    }

    @GetMapping("/info")
    public ResponseEntity currentUser(@AuthenticationPrincipal UserDetails userDetails){
        Customer customer = customerService.getCustomerByCredentials(userDetails.getUsername(),userDetails.getPassword());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Map<Object, Object> model = new HashMap<>();
        model.put("customer", customer);
        return ok(model);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(customerService.findCustomerByCustomerId(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity editCustomer(@RequestBody Customer customer, @PathVariable String id) {
        customerService.editCustomer(customer,id);
        Map<Object, Object> model = new HashMap<>();
        model.put("okej", "okej");
        return ok(model);
    }
}
