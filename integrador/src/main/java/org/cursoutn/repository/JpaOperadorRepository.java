package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.OperadorModel;

import java.util.List;

public class JpaOperadorRepository implements OperadorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OperadorModel> obtenerTodosLosOperadores() {
        return null;
    }

    @Override
    public void guardarOperador(OperadorModel operador) {

    }

    @Override
    public OperadorModel obtenerOperadorPorId(int id) {
        return null;
    }

    @Override
    public void actualizarOperador(OperadorModel operador) {

    }

    @Override
    public void eliminarOperador(OperadorModel operador) {

    }
}
