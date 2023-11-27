package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.ClienteModel;

import java.util.List;

public class JpaClienteRepository implements ClienteRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<ClienteModel> obtenerTodosLosClientes() {
        return null;
    }

    @Override
    public void guardarCliente(ClienteModel cliente) {

    }

    @Override
    public ClienteModel obtenerClientePorId(int id) {
        return null;
    }

    @Override
    public void actualizarCliente(ClienteModel cliente) {

    }

    @Override
    public void eliminarCliente(ClienteModel cliente) {

    }
}
