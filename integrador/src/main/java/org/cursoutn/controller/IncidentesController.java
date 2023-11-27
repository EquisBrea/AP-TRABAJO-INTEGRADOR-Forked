package org.cursoutn.controller;

import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.OperadorModel;
import org.cursoutn.state.EstadoIncidente;
import org.cursoutn.view.ClientesView;
import org.cursoutn.view.IncidentesView;

import java.time.LocalDateTime;

public class IncidentesController {
    private IncidenteModel model;
    private IncidentesView view;

    public IncidentesController(IncidenteModel model, IncidentesView view) {
        this.model = model;
        this.view = view;
    }
    public void setIncidenteId (int incidenteId){this.model.setId(incidenteId);}
    public void setFechaHoraIncidente(LocalDateTime fechaHoraIncidente){this.model.setFechaHoraIncidente(fechaHoraIncidente);}
    public void setTiempoNecesario (int tiempoNecesario){this.model.setTiempoNecesario(tiempoNecesario);}
    public void setEsComplejo (int esComplejo){this.model.setEsComplejo(esComplejo);}
    public void setEstadoIncidenteActual (EstadoIncidente estadoIncidenteActual){this.model.setEstadoIncidenteActual(estadoIncidenteActual);}
    public void setOperadores (OperadorModel operador){this.model.getOperadores().add(operador);}
    public void setCliente (ClienteModel cliente) {this.model.setCliente(cliente);}
}
