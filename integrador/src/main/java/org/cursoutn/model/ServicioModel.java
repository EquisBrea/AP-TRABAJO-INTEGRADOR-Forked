package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name="servicio")
public class ServicioModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreServicio;

    //Esta relación no está en el disenio original, pero puede ayudar al seguimiento de problemas de los servicios
    //ofrecidos.>>>>
    @OneToMany
    @JoinColumn(name="servicio_id", referencedColumnName = "id")
    private List<TipoProblemaModel> tiposDeProblemas;
}
