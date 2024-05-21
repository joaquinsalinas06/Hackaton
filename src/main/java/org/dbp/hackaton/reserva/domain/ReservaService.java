package org.dbp.hackaton.reserva.domain;

import org.dbp.hackaton.email.EmailService;
import org.dbp.hackaton.eventos.HelloEmailEvent;
import org.dbp.hackaton.reserva.infraestructure.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final EmailService emailService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository, EmailService emailService, ApplicationEventPublisher applicationEventPublisher) {
        this.reservaRepository = reservaRepository;
        this.emailService = emailService;
        this.applicationEventPublisher = applicationEventPublisher;
    }


    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    public String postReservas(Reserva reserva, String email) {
        applicationEventPublisher.publishEvent(new HelloEmailEvent(email));
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
