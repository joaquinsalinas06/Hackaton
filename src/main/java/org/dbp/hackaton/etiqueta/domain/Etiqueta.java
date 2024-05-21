package org.dbp.hackaton.etiqueta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dbp.hackaton.salon.domain.Salon;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtiqueta;

    private String nombre;

    @ManyToMany(mappedBy = "etiquetas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Salon> salones;

}
