package com.metropolitan.booking.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Manager> getManagerList() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getManagerByCredentials(String username, String password) {
        return managerRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Manager findByUsername(String username) {
        return managerRepository.findManagerByUsername(username);
    }

    @Override
    public void registerManager(Manager manager) {
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        managerRepository.insert(manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        managerRepository.delete(manager);
    }

    @Override
    public Manager findByManagerId(String managerId) {
        return managerRepository.findManagerByManagerId(managerId);
    }
}
