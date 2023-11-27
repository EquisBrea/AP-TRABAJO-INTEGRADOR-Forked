package org.cursoutn.repository;

import org.cursoutn.model.OperadorModel;

import java.util.List;

public interface OperadorRepository {

    public List<OperadorModel> obtenerTodosLosOperadores();

    public void guardarOperador(OperadorModel operador);

    public OperadorModel obtenerOperadorPorId(int id);

    public void actualizarOperador(OperadorModel operador);

    public void eliminarOperador(OperadorModel operador);
}
