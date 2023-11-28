package org.cursoutn.controller;

import org.cursoutn.model.*;
import org.cursoutn.state.EstadoIncidente;
import org.cursoutn.view.IncidentesView;

import java.time.LocalDateTime;
import java.util.List;

public class IncidentesController {
    private IncidenteModel model;
    private IncidentesView view;

    public IncidentesController(IncidenteModel model, IncidentesView view) {
        this.model = model;
        this.view = view;
    }
    public void setIncidenteId (int incidenteId){this.model.setId(incidenteId);}
    public int getIncidenteId () {return this.model.getId();}
    public void setFechaHoraIncidente(LocalDateTime fechaHoraIncidente){this.model.setFechaHoraIncidente(fechaHoraIncidente);}
    public LocalDateTime getFechaHoraIncidente(){return this.model.getFechaHoraIncidente();}
    public void setTiempoNecesario (int tiempoNecesario){this.model.setTiempoNecesario(tiempoNecesario);}
    public int getTiempoNecesario (){return this.model.getTiempoNecesario();}
    public void setEsComplejo (int esComplejo){this.model.setEsComplejo(esComplejo);}
    public int getEsComplejo (){return this.model.getEsComplejo();}
    public void setEstadoIncidenteActual (IncidenteState estadoIncidente){this.model.setEstadoIncidente(estadoIncidente);}
    public IncidenteState getEstadoIncidenteActual(){return this.model.getEstadoIncidente();}
    public void setOperadores (OperadorModel operador){this.model.getOperadores().add(operador);}
    public List<OperadorModel> operadores (){return this.model.getOperadores();}
    public void setCliente (ClienteModel cliente) {this.model.setCliente(cliente);}
    public ClienteModel getCliente (){return this.model.getCliente();}
    public void setTecnicos (TecnicoModel tecnico){this.model.getTecnicos().add(tecnico);}
    public List<TecnicoModel> getTecnicos (){return this.model.getTecnicos();}
    public void actualizarView (){
        view.mostrarIncidente(model.getId(), model.getFechaHoraIncidente(), model.getTiempoNecesario(), model.getEsComplejo(), this.model.getEstadoIncidente(), model.getOperadores(), model.getCliente(), model.getTecnicos(), model.getTipoProblema());
    }
}
