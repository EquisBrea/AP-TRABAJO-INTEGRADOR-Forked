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
@Table(name="notificacion")
public class NotificacionModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreNotificacion;

    @OneToMany(mappedBy = "notificacion")
    private List<ClienteModel> clientes;

    public NotificacionModel() {
        this.nombreNotificacion = "";
        this.clientes = new ArrayList<>();
    }
    public NotificacionModel(String nombreNotificacion){}
    public NotificacionModel(String nombreNotificacion, List<ClienteModel> clientes) {
        this.nombreNotificacion = nombreNotificacion;
        this.clientes = clientes;
    }


}
