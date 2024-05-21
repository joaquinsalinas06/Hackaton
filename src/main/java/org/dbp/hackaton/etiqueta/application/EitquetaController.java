package org.dbp.hackaton.etiqueta.application;

import org.dbp.hackaton.etiqueta.domain.Etiqueta;
import org.dbp.hackaton.etiqueta.domain.EtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/etiquetas")
public class EitquetaController {
    private final EtiquetaService etiquetaService;

    @Autowired
    public EitquetaController(EtiquetaService etiquetaService) {
        this.etiquetaService = etiquetaService;
    }

    @GetMapping
    public ResponseEntity<List<Etiqueta>> getEtiquetas() {
        return ResponseEntity.ok(etiquetaService.getEtiquetas());
    }

    @PostMapping
    public ResponseEntity<String> createEtiqueta(@RequestBody Etiqueta etiqueta) {
        String uri = etiquetaService.createEtiqueta(etiqueta);
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEtiqueta(@PathVariable Long id, @RequestBody Etiqueta updatedEtiqueta) {
        etiquetaService.updateEtiqueta(id, updatedEtiqueta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtiqueta(@PathVariable Long id) {
        etiquetaService.deleteEtiqueta(id);
        return ResponseEntity.noContent().build();
    }


}
