package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.Main;
import org.cursoutn.model.NotificacionModel;

import java.util.List;

public class JpaNotificacionRepository implements NotificacionRepository {

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();

    @Override
    public List<NotificacionModel> obtenerTodasLasNotificaciones() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM notificacion a", NotificacionModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros" + e);
        }
    }

    @Override
    public void guardarNotificacion(NotificacionModel notificacion) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(notificacion);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados" + e);
        }
    }

    @Override
    public NotificacionModel obtenerNotificacionPorId(int id) throws Exception {
        try {
            return entityManager.find(NotificacionModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado" + e);
        }
    }

    @Override
    public void actualizarNotificacion(NotificacionModel notificacion) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(notificacion);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar el registro Notificacion" + e);
        }
    }

    @Override
    public void eliminarNotificacion(NotificacionModel notificacion) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(notificacion) ? notificacion : entityManager.merge(notificacion));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro" + e);
        }
    }
}
