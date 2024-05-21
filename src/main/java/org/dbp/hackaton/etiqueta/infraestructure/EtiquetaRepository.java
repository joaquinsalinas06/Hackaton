package org.dbp.hackaton.etiqueta.infraestructure;

import org.dbp.hackaton.etiqueta.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
