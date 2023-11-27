package org.cursoutn.repository;

import org.cursoutn.model.OperadorModel;

import java.util.List;

public interface OperadorRepository {

    public List<OperadorModel> obtenerTodosLosOperadores() throws Exception;

    public void guardarOperador(OperadorModel operador) throws Exception;

    public OperadorModel obtenerOperadorPorId(int id) throws Exception;

    public void actualizarOperador(OperadorModel operador) throws Exception;

    public void eliminarOperador(OperadorModel operador) throws Exception;
}
