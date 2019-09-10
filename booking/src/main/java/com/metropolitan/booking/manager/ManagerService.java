package com.metropolitan.booking.manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getManagerList();

    Manager getManagerByCredentials(String username, String password);

    Manager findByUsername(String username);

    void registerManager(Manager manager);

    void deleteManager(Manager manager);

    Manager findByManagerId(String managerId);
}
