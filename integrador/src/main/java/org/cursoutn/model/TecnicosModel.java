package org.cursoutn.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tecnicos")
public class TecnicosModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreTecnico;
    @Column
    private List<IncidentesModel> incidentesResueltos;
    @ManyToOne
    @JoinColumn(name="tecnico_id", nullable = false)
    private IncidentesModel incidente;
}
