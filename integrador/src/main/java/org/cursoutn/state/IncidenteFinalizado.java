package org.cursoutn.state;

import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.IncidenteState;

public class IncidenteFinalizado extends IncidenteEstado implements EstadoIncidente {
    private final IncidenteState state;
    {
        state = IncidenteState.RESUELTO;
    }    @Override
    public void cambiarEstado(IncidenteEstado incidenteEstado) {

    }
}
