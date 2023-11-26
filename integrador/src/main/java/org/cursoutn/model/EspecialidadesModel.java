package org.cursoutn.model;

import jakarta.persistence.*;

@Entity
@Table(name="especialidades")
public class EspecialidadesModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreEspecialidad;
}
