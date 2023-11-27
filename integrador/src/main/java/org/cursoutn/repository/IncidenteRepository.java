package org.cursoutn.repository;

import org.cursoutn.model.IncidenteModel;

import java.util.List;

public interface IncidenteRepository {

    public List<IncidenteModel> obtenerTodosLosIncidentes();

    public void guardarIncidente(IncidenteModel incidente);

    public IncidenteModel obtenerIncidentePorId(int id);

    public void actualizarIncidente(IncidenteModel incidente);

    public void eliminarIncidente(IncidenteModel incidente);
}
