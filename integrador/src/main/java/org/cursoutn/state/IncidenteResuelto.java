package org.cursoutn.state;

import org.cursoutn.model.IncidenteState;

public class IncidenteResuelto extends IncidenteEstado implements EstadoIncidente {
    private final IncidenteState state;
    {
        state = IncidenteState.RESUELTO;
    }

    @Override
    public void cambiarEstado(IncidenteEstado incidenteEstado) {
        incidenteEstado.estadoIncidente.cambiarEstado(new IncidenteFinalizado());
    }
}
