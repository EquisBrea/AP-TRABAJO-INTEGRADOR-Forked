package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public class IncidenteAbierto extends IncidenteEstado implements EstadoIncidente{
    private EstadoIncidente estadoIncidente;

    @Override
    public void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado) {
        if (tecnicoModel != null) {
            incidenteEstado.getEstadoIncidente().cambiarEstado(tecnicoModel,new IncidenteAsignado());
        }
    }

    @Override
    public void mostrarEstado() {
        System.out.println(super.estadoIncidente);
    }
}
