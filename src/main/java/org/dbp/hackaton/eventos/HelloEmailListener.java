package org.dbp.hackaton.eventos;

import jakarta.mail.MessagingException;
import org.dbp.hackaton.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HelloEmailListener {

    @Autowired
    private EmailService emailService;

    @EventListener
    @Async
    public void handleHelloEmailEvent(HelloEmailEvent event) throws MessagingException {
        emailService.sendSimpleMessage(event.getEmail(), "Nueva reserva realizada con exito", "Su reserva ha sido reaizada con exito!");
    }
}