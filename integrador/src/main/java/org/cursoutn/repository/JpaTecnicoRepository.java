package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.TecnicoModel;

import java.util.List;

public class JpaTecnicoRepository implements TecnicoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TecnicoModel> obtenerTodosLosTecnicos() {
        return null;
    }

    @Override
    public void guardarTecnico(TecnicoModel tecnico) {

    }

    @Override
    public TecnicoModel obtenerTecnicoPorId(int id) {
        return null;
    }

    @Override
    public void actualizarTecnico(TecnicoModel tecnico) {

    }

    @Override
    public void eliminarTecnico(TecnicoModel tecnico) {

    }
}
