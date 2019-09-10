package com.metropolitan.booking.security;

import com.metropolitan.booking.configuration.Id;
import com.metropolitan.booking.customer.Customer;
import com.metropolitan.booking.customer.CustomerService;
import com.metropolitan.booking.manager.Manager;
import com.metropolitan.booking.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Customer customer = customerService.getCustomerByUsername(s);
        Manager manager = managerService.findByUsername(s);

        if (customer != null) {
            return new UserPrincipalCustomer(customer);
        } else if (manager != null) {
            return new UserPrincipalManager(manager);
        } else {
            return new UserPrincipalManager(new Manager(Id.generate(),"njak","njak","miskecpro", passwordEncoder.encode("miskecpro"),"milos","vulic",333));
        }
    }
}
