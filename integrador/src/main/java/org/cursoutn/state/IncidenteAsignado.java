package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public class IncidenteAsignado extends IncidenteEstado implements EstadoIncidente {
    private final State state;

    {
    state = State.ASIGNADO;
    }

    @Override
    public void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado) {

    }

    @Override
    public void mostrarEstado() {

    }

}
