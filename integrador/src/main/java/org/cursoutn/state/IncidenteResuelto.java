package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public class IncidenteResuelto extends IncidenteEstado implements EstadoIncidente {
    private final IncidenteState state;
    {
        state = IncidenteState.RESUELTO;
    }

    @Override
    public void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado) {
        incidenteEstado.estadoIncidente.cambiarEstado(tecnicoModel, new IncidenteFinalizado());
    }
}
