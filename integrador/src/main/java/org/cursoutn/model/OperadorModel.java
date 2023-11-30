package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

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
    @JoinTable
    private List<IncidenteModel> incidentes;

    public OperadorModel() {
    }

    public OperadorModel(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public OperadorModel(String nombreOperador, List<IncidenteModel> incidentes) {
        this.nombreOperador = nombreOperador;
        this.incidentes = incidentes;
    }
}
