package org.cursoutn.model;

import jakarta.persistence.*;

@Entity
@Table(name="notificacion")
public class NotificacionModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreNotificacion;
}
