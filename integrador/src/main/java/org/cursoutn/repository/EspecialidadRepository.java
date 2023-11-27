package org.cursoutn.repository;

import org.cursoutn.model.EspecialidadModel;

import java.util.List;

public interface EspecialidadRepository {

    public List<EspecialidadModel> obtenerTodasLasEspecialidades();

    public void guardarEspecialidad(EspecialidadModel especialidad);

    public EspecialidadModel obtenerEspecialidadPorId(int id);

    public void actualizarEspecialidad(EspecialidadModel especialidad);

    public void eliminarEspecialidad(EspecialidadModel especialidad);
}
