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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombreOperador;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "operador_incidente",
            joinColumns = @JoinColumn(name = "operador_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "incidente_id", referencedColumnName = "id")
    )
    private List<IncidenteModel> incidentes;
}
