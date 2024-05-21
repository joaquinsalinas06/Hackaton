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

    public void putReservas(Long id , Reserva reserva) {
        Reserva reservalocal = reservaRepository.findById(id).orElseThrow();

        reservalocal.setFecha(reserva.getFecha());
        reservalocal.setHoraInicio(reserva.getHoraInicio());
        reservalocal.setHoraFin(reserva.getHoraFin());

        reservaRepository.save(reservalocal);
    }

    public void deleteReservas(Long id) {
        reservaRepository.deleteById(id);
    }
}
