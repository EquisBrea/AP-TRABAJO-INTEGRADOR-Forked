package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaNotificacionRepository implements NotificacionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void crear(Object item) {

    }

    @Override
    public void leer(Object item) {

    }

    @Override
    public void actualizar(Object item) {

    }

    @Override
    public void eliminar(Object item) {

    }
}
