package org.dbp.hackaton.reserva.domain;

import org.dbp.hackaton.reserva.infraestructure.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }


    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    public String postReservas( Reserva reserva) {
        reservaRepository.save(reserva);
        return "/reserva/" + reserva.getIdReserva();
    }

    public void putReservas(Long id , Reserva updatedReserva) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva not found"));

        reserva.setFecha(updatedReserva.getFecha());
        reserva.setHoraInicio(updatedReserva.getHoraInicio());
        reserva.setHoraFin(updatedReserva.getHoraFin());

        reservaRepository.save(reserva);
    }

    public void deleteReservas(Long id) {
        if (!reservaRepository.existsById(id)) throw new RuntimeException("Reserva not found");
        reservaRepository.deleteById(id);
    }
}
