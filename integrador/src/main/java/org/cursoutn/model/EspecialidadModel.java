package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.repository.JpaEspecialidadRepository;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="especialidad")
public class EspecialidadModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreEspecialidad;

    @ManyToMany
    @JoinTable(
            name = "especialidad_tenico",
            joinColumns = @JoinColumn(name = "especialidad_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id", referencedColumnName = "id")
    )
    private List<TecnicoModel> tecnicos;

    @ManyToOne
    @JoinColumn(name = "tipo_problema_id")
    private TipoProblemaModel tipoProblema;

    public EspecialidadModel() {
    }

    public EspecialidadModel(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    public EspecialidadModel(String nombreEspecialidad, List<TecnicoModel> tecnicos, TipoProblemaModel tipoProblema) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.tecnicos = tecnicos;
        this.tipoProblema = tipoProblema;
    }


}
