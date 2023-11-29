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
    JpaEspecialidadRepository repository;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    public List<EspecialidadModel> obtenerTodasLasEspecialidades() throws Exception {
        return repository.obtenerTodasLasEspecialidades();
    }
    public void guardarEspecialidad(EspecialidadModel especialidadModel) throws Exception {
        repository.guardarEspecialidad(especialidadModel);
    }
    public EspecialidadModel obtenerEspecialidadPorId (int id) throws Exception {
        return repository.obtenerEspecialidadPorId(id);
    }
    public void actualizarEspecialidad(EspecialidadModel especialidadModel) throws Exception {
        repository.actualizarEspecialidad(especialidadModel);
    }
    public void eliminarEspecialidad (EspecialidadModel especialidadModel) throws Exception {
        repository.eliminarEspecialidad(especialidadModel);
    }
}
