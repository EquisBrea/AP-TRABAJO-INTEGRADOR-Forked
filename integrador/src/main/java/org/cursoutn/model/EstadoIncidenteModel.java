package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
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
