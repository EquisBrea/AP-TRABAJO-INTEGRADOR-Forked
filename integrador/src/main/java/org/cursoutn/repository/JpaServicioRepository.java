package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaServicioRepository implements ServicioRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
