package org.dbp.hackaton.salon.application;

import org.dbp.hackaton.salon.domain.Salon;
import org.dbp.hackaton.salon.domain.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/salon")
public class SalonController {

    private final SalonService salonService;

    @Autowired
    public SalonController(SalonService salonService) {
        this.salonService = salonService;
    }

    @GetMapping
    private ResponseEntity<List<Salon>> getSalones(){
        return ResponseEntity.ok(salonService.getSalones());
    }

    @PostMapping
    private ResponseEntity<String> createSalon(@RequestBody Salon salon){
        String uri = salonService.createSalon(salon);
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> updateSalon(@PathVariable Long id, @RequestBody Salon updatedSalon){
        salonService.updateSalon(id, updatedSalon);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteSalon(@PathVariable Long id){
        salonService.deleteSalon(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idSalon}/etiquetas/{idEtiqueta}")
    public ResponseEntity<Void> addEtiquetaToSalon(@PathVariable Long idSalon, @PathVariable Long idEtiqueta) {
        salonService.addEtiquetaToSalon(idSalon, idEtiqueta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idSalon}/etiquetas/{idEtiqueta}")
    public ResponseEntity<Void> removeEtiquetaFromSalon(@PathVariable Long idSalon, @PathVariable Long idEtiqueta) {
        salonService.removeEtiquetaFromSalon(idSalon, idEtiqueta);
        return ResponseEntity.ok().build();
    }
}
