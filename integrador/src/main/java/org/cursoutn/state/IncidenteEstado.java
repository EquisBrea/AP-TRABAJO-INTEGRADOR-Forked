package org.cursoutn.state;

import org.cursoutn.controller.IncidentesController;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.IncidenteState;
import org.cursoutn.model.TecnicoModel;

public class IncidenteEstado{
    protected IncidentesController incidentesController;
    public EstadoIncidente estadoIncidente;
    protected IncidenteState state;

    public EstadoIncidente getEstadoIncidente() {
        return this.estadoIncidente;
    }

    public void setEstadoIncidente(EstadoIncidente estadoIncidente) {
        this.estadoIncidente = estadoIncidente;
    }

    public IncidenteState getState() {
        return state;
    }

    public void setState(IncidenteState state) {
        this.state = state;
    }



}
