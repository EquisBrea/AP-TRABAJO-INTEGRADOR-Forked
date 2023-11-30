package org.cursoutn.repository;

import jakarta.persistence.*;
import org.cursoutn.Main;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.state.State;

import java.util.List;

public class JpaIncidenteRepository implements IncidenteRepository{

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();
    private EntityTransaction tx = entityManager.getTransaction();

    @Override
    public List<IncidenteModel> obtenerTodosLosIncidentes() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM IncidenteModel a", IncidenteModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros" + e);
        }
    }

    @Override
    public void guardarIncidente(IncidenteModel incidente) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(incidente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados" + e);
        }
    }

    @Override
    public IncidenteModel obtenerIncidentePorId(int id) throws Exception {
        try {
            return entityManager.find(IncidenteModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado" + e);
        }
    }

    @Override
    public void actualizarIncidente(IncidenteModel incidente) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(incidente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar el registro Incidente" + e);
        }
    }

    @Override
    public void eliminarIncidente(IncidenteModel incidente) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(incidente) ? incidente : entityManager.merge(incidente));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro" + e);
        }
    }

    @Override
    public void actualizarEstadoIncidente(IncidenteModel incidente, State nuevoEstado) throws Exception {
        try {
            // switch para modificar el estado con los métodos de IncidenteModel, con nuevoEstado como condición
            incidente.setEstadoIncidente(nuevoEstado);
            entityManager.getTransaction().begin();
            entityManager.merge(incidente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar estado" + e);
        }
    }
}
