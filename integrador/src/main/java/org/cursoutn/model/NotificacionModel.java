package org.cursoutn.model;

import jakarta.persistence.*;

@Entity
@Table(name="notificaciones")
public class NotificacionModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreNotificacion;
}
