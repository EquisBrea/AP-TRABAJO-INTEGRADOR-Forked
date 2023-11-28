package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public class IncidenteAbierto extends IncidenteEstado implements EstadoIncidente{
    private static IncidenteState ABIERTO;

    @Override
    public void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado) {
        if (tecnicoModel != null) {
            incidenteEstado.estadoIncidente.cambiarEstado(tecnicoModel,new IncidenteAsignado());
            super.incidentesController.setEstadoIncidenteActual(super.state);
        }
    }
}
