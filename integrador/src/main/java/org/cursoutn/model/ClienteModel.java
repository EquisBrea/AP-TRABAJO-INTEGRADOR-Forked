package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class ClienteModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String razon_social;
    @Column
    private long cuil;
    @OneToMany
    @MapsId
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<NotificacionModel> notificaciones;
    @OneToMany
    @MapsId
    @JoinColumn(name="cliente_id",referencedColumnName = "id")
    private List<ServicioModel> servicio;
    @OneToMany
    @MapsId
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private List<IncidenteModel> incidentes;

}
