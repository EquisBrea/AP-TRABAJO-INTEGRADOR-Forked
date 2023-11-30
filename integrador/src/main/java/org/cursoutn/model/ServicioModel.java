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
@Table(name="servicio")
public class ServicioModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreServicio;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "servicios")
    private List<ClienteModel> clientes;

    //Esta relación no está en el disenio original, pero puede ayudar al seguimiento de problemas de los servicios
    //ofrecidos.>>>>
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "servicios")
    private List<TipoProblemaModel> tiposDeProblemas;

    public ServicioModel() {
        this.nombreServicio ="";
        this.clientes = new ArrayList<>();
        this.tiposDeProblemas = new ArrayList<>();
    }

    public ServicioModel(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public ServicioModel(String nombreServicio, List<ClienteModel> clientes, List<TipoProblemaModel> tiposDeProblemas) {
        this.nombreServicio = nombreServicio;
        this.clientes = clientes;
       // this.tiposDeProblemas = tiposDeProblemas;
    }
}
