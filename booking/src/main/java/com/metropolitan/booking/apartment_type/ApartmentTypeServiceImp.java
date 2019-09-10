package com.metropolitan.booking.apartment_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentTypeServiceImp implements ApartmentTypeService {

    @Autowired
    private ApartmentTypeRepository apartmentTypeRepository;

    @Override
    public List<ApartmentType> findAllTypes() {
        return apartmentTypeRepository.findAll();
    }

    @Override
    public int findApartmentTypeByNaziv(String nazivApartmentType) {
        for (ApartmentType apartmentType : apartmentTypeRepository.findAll()) {
            if (apartmentType.getNazivApartmentType().equals(nazivApartmentType)) {
                return apartmentType.getIdApartmentType();
            }
        }
        return 0;
    }

    @Override
    public void addApartmentType(ApartmentType apartmentType) {
        apartmentTypeRepository.insert(apartmentType);
    }

    @Override
    public void deleteApartmentType(ApartmentType apartmentType) {
        apartmentTypeRepository.delete(apartmentType);
    }

    @Override
    public ApartmentType findByNaziv(String nazivApartmentType) {
        return apartmentTypeRepository.findByNazivApartmentType(nazivApartmentType);
    }
}
