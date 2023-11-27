package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.EspecialidadModel;

import java.util.List;

public class JpaEspecialidadRepository implements EspecialidadRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EspecialidadModel> obtenerTodasLasEspecialidades() {
        return null;
    }

    @Override
    public void guardarEspecialidad(EspecialidadModel especialidad) {

    }

    @Override
    public EspecialidadModel obtenerEspecialidadPorId(int id) {
        return null;
    }

    @Override
    public void actualizarEspecialidad(EspecialidadModel especialidad) {

    }

    @Override
    public void eliminarEspecialidad(EspecialidadModel especialidad) {

    }
}
