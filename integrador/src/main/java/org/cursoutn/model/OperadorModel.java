package org.cursoutn.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="operador")
public class OperadorModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreOperador;
    @ManyToMany
    @JoinColumn(name="incidente_id", referencedColumnName = "id")
    private List<IncidenteModel> incidentes;
}
