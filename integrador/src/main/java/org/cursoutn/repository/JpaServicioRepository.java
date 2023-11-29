package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.Main;
import org.cursoutn.model.ServicioModel;

import java.util.List;

public class JpaServicioRepository implements ServicioRepository {

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();

    @Override
    public List<ServicioModel> obtenerTodosLosServicios() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM servicio a", ServicioModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros");
        }
    }

    @Override
    public void guardarServicio(ServicioModel servicio) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(servicio);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados");
        }
    }

    @Override
    public ServicioModel obtenerServicioPorId(int id) throws Exception {
        try {
            return entityManager.find(ServicioModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado");
        }
    }

    @Override
    public void actualizarServicio(ServicioModel servicio) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(servicio);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar el registro");
        }
    }

    @Override
    public void eliminarServicio(ServicioModel servicio) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(servicio) ? servicio : entityManager.merge(servicio));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro");
        }
    }
}
