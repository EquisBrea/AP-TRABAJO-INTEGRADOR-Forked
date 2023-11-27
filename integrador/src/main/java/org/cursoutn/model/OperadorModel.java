package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
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
