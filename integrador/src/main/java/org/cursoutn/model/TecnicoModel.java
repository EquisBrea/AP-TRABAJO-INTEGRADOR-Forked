package org.cursoutn.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tecnico")
public class TecnicoModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreTecnico;
    @ManyToMany
    private List<IncidenteModel> incidentes;
    @ManyToMany
    private List<EspecialidadModel> especialidades;
}
