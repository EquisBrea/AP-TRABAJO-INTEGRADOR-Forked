package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaEspecialidadRepository implements EspecialidadRepository{

    @PersistenceContext
    private EntityManager entityManager;
}
