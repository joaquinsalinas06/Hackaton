package org.dbp.hackaton.etiqueta.domain;

import org.dbp.hackaton.etiqueta.infraestructure.EtiquetaRepository;
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

    public void updateEtiqueta(Long id, Etiqueta etiqueta) {
        Etiqueta etiquetalocal = etiquetaRepository.findById(id).orElseThrow();
        etiquetalocal.setNombre(etiqueta.getNombre());

        etiquetaRepository.save(etiquetalocal);
    }

    public void deleteEtiqueta(Long id) {
        etiquetaRepository.deleteById(id);
    }
}
