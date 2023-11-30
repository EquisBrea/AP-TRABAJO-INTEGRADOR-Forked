package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.repository.JpaEspecialidadRepository;
import org.cursoutn.view.TipoProblemaView;
import org.hibernate.annotations.DynamicInsert;

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

    @Column(columnDefinition = "varchar(255) default 'Sistemas'")
    private String nombreEspecialidad;

    @ManyToMany
    @JoinTable(
            name = "tipo_problema_especialidad",
            joinColumns = @JoinColumn(name = "tipo_problema_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn (name = "especialidad_id",referencedColumnName = "id")
    )
    private List<TipoProblemaModel> tipoProblemaModels;

    @ManyToMany
    @JoinTable(
            name = "especialidad_tenico",
            joinColumns = @JoinColumn(name = "especialidad_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id", referencedColumnName = "id")
    )
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
