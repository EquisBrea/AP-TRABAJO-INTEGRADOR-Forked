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
@Table(name="tipo_problema")

public class TipoProblemaModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreTipoProblema;

    @ManyToMany
    private List<IncidenteModel> incidentes;

    @ManyToMany(mappedBy = "tiposDeProblemas")
    private List<EspecialidadModel> especialidades;

    @ManyToMany
    private List<ServicioModel> servicios;

    public TipoProblemaModel() {
        this.nombreTipoProblema ="";
        this.incidentes = new ArrayList<>();
        this.especialidades = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public TipoProblemaModel(List<EspecialidadModel> especialidades, List<ServicioModel> servicio) {
        this.especialidades = especialidades;
        this.servicios = servicio;
    }


}
