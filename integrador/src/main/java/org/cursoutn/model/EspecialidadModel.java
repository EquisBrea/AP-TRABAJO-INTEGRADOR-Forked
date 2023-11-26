package org.cursoutn.model;

import jakarta.persistence.*;

@Entity
@Table(name="especialidades")
public class EspecialidadModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreEspecialidad;
}
