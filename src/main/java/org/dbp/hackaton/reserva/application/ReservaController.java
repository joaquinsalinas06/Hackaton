package org.dbp.hackaton.reserva.application;

import org.dbp.hackaton.reserva.domain.Reserva;
import org.dbp.hackaton.reserva.domain.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    private ResponseEntity<List<Reserva>> getReservas(){
        return ResponseEntity.ok(reservaService.getReservas());
    }

    @PostMapping
    private ResponseEntity<String> postReservas(@RequestBody Reserva reserva, @RequestParam String email){
        String uri = reservaService.postReservas(reserva, email);
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> putReservas(@PathVariable Long id, @RequestBody Reserva updatedReserva){
        reservaService.putReservas(id, updatedReserva);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteReservas(@PathVariable Long id){
        reservaService.deleteReservas(id);
        return ResponseEntity.noContent().build();
    }
}
