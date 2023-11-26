package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaNotificacionRepository implements NotificacionRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
