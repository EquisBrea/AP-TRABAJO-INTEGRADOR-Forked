package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

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

    @ManyToMany
    @JoinTable(
            name ="tipo_problema_especialidad",
            joinColumns = @JoinColumn(name="incidente_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="tipo_problema_id", referencedColumnName = "id"))
            private List<EspecialidadModel> especialidades;

/*
    @ManyToOne()
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private ServicioModel servicios;
*/

    public TipoProblemaModel() {
    }
/*
    public TipoProblemaModel(List<EspecialidadModel> especialidades, ServicioModel servicio) {
        this.especialidades = especialidades;
        this.servicios = servicio;
    }

 */
}
