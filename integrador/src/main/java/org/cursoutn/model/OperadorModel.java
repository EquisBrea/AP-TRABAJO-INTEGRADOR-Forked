package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="operador")
public class OperadorModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(255) default 'Elsa Balo'")
    private String nombreOperador;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "operadores")
    private List<IncidenteModel> incidentes;

    public OperadorModel() {
        this.nombreOperador ="";
        this.incidentes = new ArrayList<>();
    }

    public OperadorModel(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public OperadorModel(String nombreOperador, List<IncidenteModel> incidentes) {
        this.nombreOperador = nombreOperador;
        this.incidentes = incidentes;
    }
}
