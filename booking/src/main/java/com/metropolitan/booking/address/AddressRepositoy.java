package com.metropolitan.booking.address;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoy extends MongoRepository<Address, String> {
    Address findByIdAddress(String idAddress);
}
