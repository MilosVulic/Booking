package com.metropolitan.booking.address;

import java.util.List;

public interface AddressService {

    void addAddress(Address address);

    Address findAddressById(String idAddress);

    List<Address> showAllAddresses();
}
