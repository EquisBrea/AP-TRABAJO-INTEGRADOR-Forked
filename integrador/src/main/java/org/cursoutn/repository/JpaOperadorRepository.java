package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.Main;
import org.cursoutn.model.OperadorModel;

import java.util.List;

public class JpaOperadorRepository implements OperadorRepository {

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();

    @Override
    public List<OperadorModel> obtenerTodosLosOperadores() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM operador a", OperadorModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros" + e);
        }
    }

    @Override
    public void guardarOperador(OperadorModel operador) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(operador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados" + e);
        }
    }

    @Override
    public OperadorModel obtenerOperadorPorId(int id) throws Exception {
        try {
            return entityManager.find(OperadorModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado" + e);
        }
    }

    @Override
    public void actualizarOperador(OperadorModel operador) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(operador);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar el registro operador" + e);
        }
    }

    @Override
    public void eliminarOperador(OperadorModel operador) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(operador) ? operador : entityManager.merge(operador));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro" + e);
        }
    }
}
