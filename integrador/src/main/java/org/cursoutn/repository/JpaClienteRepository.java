package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaClienteRepository implements IncidenteRepository{

    @PersistenceContext
    private EntityManager entityManager;
}
