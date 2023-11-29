package org.cursoutn.repository;

import org.cursoutn.model.ClienteModel;

import java.util.List;

public interface ClienteRepository {

    public List<ClienteModel> obtenerTodosLosClientes() throws Exception;

    public void guardarCliente(ClienteModel cliente) throws Exception;

    public ClienteModel obtenerClientePorId(Integer id) throws Exception;

    public void actualizarCliente(ClienteModel cliente) throws Exception;

    public void eliminarCliente(ClienteModel cliente) throws Exception;

}
