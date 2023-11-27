package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.TipoProblemaModel;

import java.util.List;

public class JpaTipoProblemaRepository implements TipoProblemaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TipoProblemaModel> obtenerTodosLosTipoProblema() {
        return null;
    }

    @Override
    public void guardarTipoProblema(TipoProblemaModel tipoProblema) {

    }

    @Override
    public TipoProblemaModel obtenerTipoProblemaPorId(int id) {
        return null;
    }

    @Override
    public void actualizarTipoProblema(TipoProblemaModel tipoProblema) {

    }

    @Override
    public void eliminarTipoProblema(TipoProblemaModel tipoProblema) {

    }
}
