package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.IncidenteModel;

import java.util.List;

public class JpaIncidenteRepository implements IncidenteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<IncidenteModel> obtenerTodosLosIncidentes() {
        return null;
    }

    @Override
    public void guardarIncidente(IncidenteModel incidente) {

    }

    @Override
    public IncidenteModel obtenerIncidentePorId(int id) {
        return null;
    }

    @Override
    public void actualizarIncidente(IncidenteModel incidente) {

    }

    @Override
    public void eliminarIncidente(IncidenteModel incidente) {

    }
}
