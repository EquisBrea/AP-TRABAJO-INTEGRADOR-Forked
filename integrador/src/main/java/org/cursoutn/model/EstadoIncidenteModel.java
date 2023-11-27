package org.cursoutn.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="estado_incidente")
public class EstadoIncidenteModel implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String estadoDescripcion;
    @OneToMany(mappedBy = "estado_incidente", cascade = CascadeType.ALL)
    private List<IncidenteModel> incidentes;
}
