package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public class IncidenteAsignado extends IncidenteEstado implements EstadoIncidente {
    private final IncidenteState state;

    {
    state = IncidenteState.ASIGNADO;
    }

    @Override
    public void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado) {

    }

}
