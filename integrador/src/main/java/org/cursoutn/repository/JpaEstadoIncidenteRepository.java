package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaEstadoIncidenteRepository implements EstadoIncidenteRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
