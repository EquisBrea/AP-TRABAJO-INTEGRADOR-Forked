package org.cursoutn.repository;

import org.cursoutn.model.ServicioModel;

import java.util.List;

public interface ServicioRepository {

    public List<ServicioModel> obtenerTodosLosServicios() throws Exception;

    public void guardarServicio(ServicioModel servicio) throws Exception;

    public ServicioModel obtenerServicioPorId(int id) throws Exception;

    public void actualizarServicio(ServicioModel servicio) throws Exception;

    public void eliminarServicio(ServicioModel servicio) throws Exception;
}
