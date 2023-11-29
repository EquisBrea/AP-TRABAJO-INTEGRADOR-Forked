package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name="tecnico")
public class TecnicoModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombreTecnico;

    @ManyToMany
    private List<IncidenteModel> incidentes;

    @ManyToMany
    private List<EspecialidadModel> especialidades;
}
