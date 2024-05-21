package org.dbp.hackaton.salon.domain;

import org.dbp.hackaton.exception.ResourceNotFoundException;
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

    public void updateSalon(Long id, Salon updatedSalon){
        Salon salon = salonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Salon not found"));

        salon.setNombre(updatedSalon.getNombre());
        salon.setUbicacion(updatedSalon.getUbicacion());
        salon.setCapacidad(updatedSalon.getCapacidad());
        salon.setDescripcion(updatedSalon.getDescripcion());

        salonRepository.save(salon);
    }

    public void deleteSalon(Long id) {
        if (!salonRepository.existsById(id)) throw new ResourceNotFoundException("Salon not found");
        salonRepository.deleteById(id);
    }
}
