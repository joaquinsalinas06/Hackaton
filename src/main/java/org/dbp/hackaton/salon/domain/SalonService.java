package org.dbp.hackaton.salon.domain;

import org.dbp.hackaton.salon.infrastructure.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {
    private final SalonRepository salonRepository;

    @Autowired
    public SalonService(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    public List<Salon> getSalones() {
        return salonRepository.findAll();
    }

    public String createSalon(Salon salon) {
        salonRepository.save(salon);
        return "/salon/" + salon.getIdSalon();
    }

    public void updateSalon(Long id){
        Salon salon = salonRepository.findById(id).orElseThrow();

        salon.setNombre(salon.getNombre());
        salon.setUbicacion(salon.getUbicacion());
        salon.setCapacidad(salon.getCapacidad());
        salon.setDescripcion(salon.getDescripcion());

        salonRepository.save(salon);
    }

    public void deleteSalon(Long id) {
        salonRepository.deleteById(id);
    }
}
