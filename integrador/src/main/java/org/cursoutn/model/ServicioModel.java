package org.cursoutn.model;

import jakarta.persistence.*;

@Entity
@Table(name="servicios")
public class ServicioModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreServicio;
}
