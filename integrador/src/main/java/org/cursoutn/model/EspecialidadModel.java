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
    @GeneratedValue
    private int id;
    @Column
    private String nombreEspecialidad;
    @ManyToMany(mappedBy = "especialidad")
    private List<TecnicoModel> tecnicos;


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
