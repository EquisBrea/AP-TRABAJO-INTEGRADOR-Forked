package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.Main;
import org.cursoutn.model.EspecialidadModel;

import java.util.List;

public class JpaEspecialidadRepository implements EspecialidadRepository{

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();

    @Override
    public List<EspecialidadModel> obtenerTodasLasEspecialidades() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM EspecialidadModel a", EspecialidadModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros" + e);
        }
    }

    @Override
    public void guardarEspecialidad(EspecialidadModel especialidad) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(especialidad);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados" + e);
        }
    }

    @Override
    public EspecialidadModel obtenerEspecialidadPorId(int id) throws Exception {
        try {
            return entityManager.find(EspecialidadModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado" + e);
        }
    }

    @Override
    public void actualizarEspecialidad(EspecialidadModel especialidad) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(especialidad);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(" 1231 Error al actualizar el registro" + e);
        }
    }

    @Override
    public void eliminarEspecialidad(EspecialidadModel especialidad) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(especialidad) ? especialidad : entityManager.merge(especialidad));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro" + e);
        }
    }
}
