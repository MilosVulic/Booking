package com.metropolitan.booking.apartment_beds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentBedsServiceImp implements ApartmentBedsService {

    @Autowired
    private ApartmentBedsRepository apartmentBedsRepository;

    @Override
    public List<ApartmentBeds> findAllBeds() {
        return apartmentBedsRepository.findAll();
    }

    @Override
    public int findApartmentBedIdByNaziv(String naziv) {
        for (ApartmentBeds ab : apartmentBedsRepository.findAll()) {
            if (ab.getNaziv().equals(naziv)) {
                return ab.getIdApartmentBeds();
            }
        }
        return 0;
    }

    @Override
    public void addApartmentBeds(ApartmentBeds apartmentBeds) {
        apartmentBedsRepository.insert(apartmentBeds);
    }

    @Override
    public void deleteApartmentBeds(ApartmentBeds apartmentBeds) {
        apartmentBedsRepository.delete(apartmentBeds);
    }

    @Override
    public ApartmentBeds findApartmentBedsByName(String naziv) {
        return apartmentBedsRepository.findByNaziv(naziv);
    }
}
