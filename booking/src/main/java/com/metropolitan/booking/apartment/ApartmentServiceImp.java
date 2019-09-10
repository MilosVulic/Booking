package com.metropolitan.booking.apartment;

import com.metropolitan.booking.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentServiceImp implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Override
    public List<Apartment> getApartmentsByMnaager(Manager manager) {
        return apartmentRepository.findApartmentsByManager(manager);
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    @Override
    public void addApartment(Apartment apartment) {
        apartmentRepository.insert(apartment);
    }

    @Override
    public void removeApapartment(Apartment apartment) {
        apartmentRepository.delete(apartment);
    }

    @Override
    public Apartment getApartmentById(String apartmentId) {
        System.out.println("spanija " + apartmentId);
        System.out.println();

        for(Apartment a : apartmentRepository.findAll()){
            if(a.getApartmentId().equals(apartmentId)){
                return a;
            }
        }

        return apartmentRepository.findApartmentBy(apartmentId);
    }
}
