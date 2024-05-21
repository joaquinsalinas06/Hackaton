package org.dbp.hackaton.salon.domain;

import org.dbp.hackaton.etiqueta.domain.Etiqueta;
import org.dbp.hackaton.etiqueta.infraestructure.EtiquetaRepository;
import org.dbp.hackaton.exception.ResourceNotFoundException;
import org.dbp.hackaton.salon.infrastructure.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {
    private final SalonRepository salonRepository;
    private final EtiquetaRepository etiquetaRepository;

    @Autowired
    public SalonService(SalonRepository salonRepository, EtiquetaRepository etiquetaRepository) {
        this.salonRepository = salonRepository;
        this.etiquetaRepository = etiquetaRepository;
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

    public void addEtiquetaToSalon(Long salonId, Long etiquetaId) {
        Salon salon = salonRepository.findById(salonId)
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found"));
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new ResourceNotFoundException("Etiqueta not found"));

        salon.getEtiquetas().add(etiqueta);
        salonRepository.save(salon);
    }

    public void removeEtiquetaFromSalon(Long salonId, Long etiquetaId) {
        Salon salon = salonRepository.findById(salonId)
                .orElseThrow(() -> new ResourceNotFoundException("Salon not found"));
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new ResourceNotFoundException("Etiqueta not found"));

        salon.getEtiquetas().remove(etiqueta);
        salonRepository.save(salon);
    }




}
