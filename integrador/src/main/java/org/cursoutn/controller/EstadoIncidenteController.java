package org.cursoutn.controller;

import org.cursoutn.model.IncidenteModel;
import org.cursoutn.view.EstadoIncidenteView;

import java.util.List;

public class EstadoIncidenteController {
    private EstadoIncidenteModel model;
    private EstadoIncidenteView view;

    public EstadoIncidenteController(EstadoIncidenteModel model, EstadoIncidenteView view) {
        this.model = model;
        this.view = view;
    }
    public void setEstadoIncidenteId(int estadoIncidenteId){
        this.model.setId(estadoIncidenteId);
    }
    public int getEstadoIncidente(){
        return this.model.getId();
    }
    public void setEstadoDescripcion(String estadoDescripcion){
        this.model.setEstadoDescripcion(estadoDescripcion);
    }
    public String getEstadoDescripcion(){
        return this.model.getEstadoDescripcion();
    }
    public void setListadoIncidentes(IncidenteModel incidentes){
        this.model.getIncidentes().add(incidentes);
    }
    public List<IncidenteModel> listadoIncidentes (){
        return this.model.getIncidentes();
    }

    public void actualizarView (){
        view.mostrarEstadoIncidente(this.model.getId(), this.model.getEstadoDescripcion(), this.model.getIncidentes());
    }
}
