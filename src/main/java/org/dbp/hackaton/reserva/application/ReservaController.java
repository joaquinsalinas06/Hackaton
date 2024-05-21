package org.dbp.hackaton.reserva.application;

import org.dbp.hackaton.reserva.domain.Reserva;
import org.dbp.hackaton.reserva.domain.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    private ResponseEntity<Reserva> getReservas(){
        return ResponseEntity.ok(reservaService.getReservas());
    }

    @PostMapping
    private ResponseEntity<String> postReservas(){
        String uri = reservaService.postReservas();
        return ResponseEntity.created(URI.create(uri)).build();
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> putReservas(){
        reservaService.putReservas();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteReservas(){
        reservaService.deleteReservas();
        return ResponseEntity.noContent().build();
    }
}
