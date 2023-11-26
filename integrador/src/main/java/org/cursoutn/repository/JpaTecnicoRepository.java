package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JpaTecnicoRepository implements TecnicoRepository {

    @PersistenceContext
    private EntityManager entityManager;
}
