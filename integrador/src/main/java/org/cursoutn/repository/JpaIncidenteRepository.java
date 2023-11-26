package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaIncidenteRepository implements IncidenteRepository{

    @PersistenceContext
    private EntityManager entityManager;
}
