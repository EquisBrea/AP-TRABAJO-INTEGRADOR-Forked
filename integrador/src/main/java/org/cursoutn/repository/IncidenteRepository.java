package org.cursoutn.repository;

import org.cursoutn.model.IncidenteModel;
import org.cursoutn.state.State;

import java.util.List;

public interface IncidenteRepository {

    public List<IncidenteModel> obtenerTodosLosIncidentes() throws Exception;

    public void guardarIncidente(IncidenteModel incidente) throws Exception;

    public IncidenteModel obtenerIncidentePorId(int id) throws Exception;

    public void actualizarIncidente(IncidenteModel incidente) throws Exception;

    public void eliminarIncidente(IncidenteModel incidente) throws Exception;

    public void actualizarEstadoIncidente(IncidenteModel incidente, State nuevoEstado) throws Exception;
}
