package org.cursoutn.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="especialidad")
public class EspecialidadModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreEspecialidad;
    @ManyToMany(mappedBy = "especialidad")
    private List<TecnicoModel> tecnicos;

}
