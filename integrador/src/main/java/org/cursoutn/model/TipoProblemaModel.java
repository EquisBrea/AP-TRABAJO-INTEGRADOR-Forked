package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name="tipo_problema")
public class TipoProblemaModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombreTipoProblema;

    @ManyToMany(mappedBy = "tipoProblema")
    @Column(name="incidente_id", nullable = false)
    private List<IncidenteModel> incidentes;

    @OneToMany
    @JoinColumn(name="tipo_problema_id", referencedColumnName = "id")
    private List<EspecialidadModel> especialidades;
}
