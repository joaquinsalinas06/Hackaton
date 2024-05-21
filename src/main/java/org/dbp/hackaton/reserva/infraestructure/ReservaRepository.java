package org.dbp.hackaton.reserva.infraestructure;

import org.dbp.hackaton.reserva.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
