package org.dbp.hackaton.salon.infrastructure;

import org.dbp.hackaton.salon.domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
}
