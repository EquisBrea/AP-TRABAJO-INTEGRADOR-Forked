package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Setter
@Entity
@DynamicInsert
@Table(name="notificacion")
public class NotificacionModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = " varchar(255) default 'Correo electronico'")
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
