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
    @GeneratedValue
    private int id;
    @Column
    private String nombreTipoProblema;
    @ManyToMany
    @JoinColumn(name="incidente_id", nullable = false)
    private List<IncidenteModel> incidentes;
    @OneToMany
    @JoinColumn(name="tipo_problema_id", referencedColumnName = "id")
    private List<EspecialidadModel> especialidades;
}
