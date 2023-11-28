package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public class IncidenteFinalizado extends IncidenteEstado implements EstadoIncidente {
    private final IncidenteState state;
    {
        state = IncidenteState.RESUELTO;
    }    @Override
    public void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado) {

    }
}
