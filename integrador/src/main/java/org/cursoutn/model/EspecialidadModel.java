package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.repository.JpaEspecialidadRepository;
import org.cursoutn.view.TipoProblemaView;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;

@Getter
@Setter
@Entity
@Table(name="especialidad")
public class EspecialidadModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombreEspecialidad;

    @ManyToMany
    private List<TipoProblemaModel> tipoProblemaModels;

    @ManyToMany(mappedBy = "especialidades")
    private List<TecnicoModel> tecnicos;


    public EspecialidadModel() {
    }

    public EspecialidadModel(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public EspecialidadModel(String nombreEspecialidad, List<TecnicoModel> tecnicos, TipoProblemaModel tipoProblema) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.tecnicos = tecnicos;
    }


}
