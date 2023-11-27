package org.cursoutn.repository;

import org.cursoutn.model.ClienteModel;

import java.util.List;

public interface ClienteRepository {

    public List<ClienteModel> obtenerTodosLosClientes();

    public void guardarCliente(ClienteModel cliente);

    public ClienteModel obtenerClientePorId(int id);

    public void actualizarCliente(ClienteModel cliente);

    public void eliminarCliente(ClienteModel cliente);

}
