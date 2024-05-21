package org.dbp.hackaton.etiqueta.application;

import org.dbp.hackaton.etiqueta.domain.Etiqueta;
import org.dbp.hackaton.etiqueta.domain.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/etiquetas")
public class EitquetaController {
    private final EtiquetaService etiquetaService;

    @Autowired
    public EitquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
    public ResponseEntity<Etiqueta> getEtiquetas() {
        return ResponseEntity.ok(etiquetaService.getEtiquetas());
    }

    @PostMapping
    public ResponseEntity<String> createEtiqueta(@RequestBody Etiqueta etiqueta) {
        String uri = etiquetaService.createEtiqueta(etiqueta);
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEtiqueta(@PathVariable Long id, @RequestBody Etiqueta etiqueta) {
        return ResponseEntity.ok(etiquetaService.updateEtiqueta(etiqueta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtiqueta(@PathVariable Long id) {
        etiquetaService.deleteEtiqueta(id);
        return ResponseEntity.noContent().build();
    }


}
