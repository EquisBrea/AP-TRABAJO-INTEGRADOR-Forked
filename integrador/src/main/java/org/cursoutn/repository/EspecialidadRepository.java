package org.cursoutn.repository;

import org.cursoutn.model.EspecialidadModel;

import java.util.List;

public interface EspecialidadRepository {

    public List<EspecialidadModel> obtenerTodasLasEspecialidades() throws Exception;

    public void guardarEspecialidad(EspecialidadModel especialidad) throws Exception;

    public EspecialidadModel obtenerEspecialidadPorId(int id) throws Exception;

    public void actualizarEspecialidad(EspecialidadModel especialidad) throws Exception;

    public void eliminarEspecialidad(EspecialidadModel especialidad) throws Exception;
}
