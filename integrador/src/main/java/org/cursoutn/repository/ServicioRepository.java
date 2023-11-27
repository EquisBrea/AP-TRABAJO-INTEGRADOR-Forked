package org.cursoutn.repository;

import org.cursoutn.model.ServicioModel;

import java.util.List;

public interface ServicioRepository {

    public List<ServicioModel> obtenerTodosLosServicios();

    public void guardarServicio(ServicioModel servicio);

    public ServicioModel obtenerServicioPorId(int id);

    public void actualizarServicio(ServicioModel servicio);

    public void eliminarServicio(ServicioModel servicio);
}
