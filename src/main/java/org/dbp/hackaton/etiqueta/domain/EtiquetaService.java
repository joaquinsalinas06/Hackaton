package org.dbp.hackaton.etiqueta.domain;

import org.dbp.hackaton.etiqueta.infraestructure.EtiquetaRepository;
import org.dbp.hackaton.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaService {
    private final EtiquetaRepository etiquetaRepository;

    @Autowired
    public EtiquetaService(EtiquetaRepository etiquetaRepository) {
        this.etiquetaRepository = etiquetaRepository;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetaRepository.findAll();
    }

    public String createEtiqueta(Etiqueta etiqueta) {
        etiquetaRepository.save(etiqueta);
        return "/etiquetas/" + etiqueta.getIdEtiqueta();
    }

    public void updateEtiqueta(Long id, Etiqueta updatedEtiqueta) {
        Etiqueta etiqueta = etiquetaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etiqueta not found"));
        etiqueta.setNombre(updatedEtiqueta.getNombre());
        etiquetaRepository.save(etiqueta);
    }

    public void deleteEtiqueta(Long id) {
        if (!etiquetaRepository.existsById(id)) throw new ResourceNotFoundException("Etiqueta not found");
        etiquetaRepository.deleteById(id);
    }
}
