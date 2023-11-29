package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="notificacion")
public class NotificacionModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreNotificacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
    private ClienteModel cliente;

    public NotificacionModel() {
    }

    public NotificacionModel(String nombreNotificacion, ClienteModel cliente) {
        this.nombreNotificacion = nombreNotificacion;
        this.cliente = cliente;
    }


}
