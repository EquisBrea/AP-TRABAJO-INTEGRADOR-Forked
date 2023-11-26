package org.cursoutn.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="incidentes")
public class IncidentesModel implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private LocalDateTime fechaHoraIncidente;
    @Column
    private int tiempoNecesario;
    @Column
    private int esComplejo;

    @OneToOne
    @MapsId
    @JoinColumn(name= "estado_incidente_id", referencedColumnName = "id" )
    private EstadoIncidenteModel estadoIncidente;
    @OneToMany
    @MapsId
    @JoinColumn(name="tipo_problema",referencedColumnName = "id")
    private List<TipoProblemaModel> tipoProblema;
    @OneToMany
    @MapsId
    @JoinColumn(name = "tecnico", referencedColumnName = "id")
    private List<TecnicosModel> tecnicos;

}
