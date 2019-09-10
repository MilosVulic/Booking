package com.metropolitan.booking.manager;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

    Manager findByUsernameAndPassword(String username, String password);

    Manager findManagerByUsername(String username);

    Manager findManagerByManagerId(String managerId);
}
