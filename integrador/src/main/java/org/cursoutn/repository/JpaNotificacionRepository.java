package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.NotificacionModel;

import java.util.List;

public class JpaNotificacionRepository implements NotificacionRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<NotificacionModel> obtenerTodasLasNotificaciones() {
        return null;
    }

    @Override
    public void guardarNotificacion(NotificacionModel notificacion) {

    }

    @Override
    public NotificacionModel obtenerNotificacionPorId(int id) {
        return null;
    }

    @Override
    public void actualizarNotificacion(NotificacionModel notificacion) {

    }

    @Override
    public void eliminarNotificacion(NotificacionModel notificacion) {

    }
}
