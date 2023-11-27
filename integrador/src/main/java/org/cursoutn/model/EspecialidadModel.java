package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
