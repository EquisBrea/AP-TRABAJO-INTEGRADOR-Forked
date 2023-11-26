package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaOperadorRepository implements OperadorRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
