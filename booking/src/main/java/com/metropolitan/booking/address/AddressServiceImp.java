package com.metropolitan.booking.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepositoy addressRepositoy;

    @Override
    public void addAddress(Address address) {
        addressRepositoy.insert(address);
    }

    @Override
    public Address findAddressById(String idAddress) {
        return addressRepositoy.findByIdAddress(idAddress);
    }

    @Override
    public List<Address> showAllAddresses() {
        return addressRepositoy.findAll();
    }
}
