package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.ServicioModel;

import java.util.List;

public class JpaServicioRepository implements ServicioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ServicioModel> obtenerTodosLosServicios() {
        return null;
    }

    @Override
    public void guardarServicio(ServicioModel servicio) {

    }

    @Override
    public ServicioModel obtenerServicioPorId(int id) {
        return null;
    }

    @Override
    public void actualizarServicio(ServicioModel servicio) {

    }

    @Override
    public void eliminarServicio(ServicioModel servicio) {

    }
}
