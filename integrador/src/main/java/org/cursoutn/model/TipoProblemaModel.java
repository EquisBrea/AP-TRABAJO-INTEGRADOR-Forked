package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;
@Getter
@Setter
@Entity
@DynamicInsert
@Table(name="tipo_problema")
public class TipoProblemaModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreTipoProblema;

    @ManyToMany(mappedBy = "tipoProblema")
    @Column(name="incidente_id")
    private List<IncidenteModel> incidentes;

    @OneToMany
    @JoinColumn(name ="especialidad_id", referencedColumnName = "id")
    private List<EspecialidadModel> especialidades;

    @ManyToOne()
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private ServicioModel servicios;


    public TipoProblemaModel() {
    }

    public TipoProblemaModel(List<EspecialidadModel> especialidades, ServicioModel servicio) {
        this.especialidades = especialidades;
        this.servicios = servicio;
    }
}
