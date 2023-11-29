package org.cursoutn.state;

import org.cursoutn.model.TecnicoModel;

public interface EstadoIncidente {
    void cambiarEstado(TecnicoModel tecnicoModel, IncidenteEstado incidenteEstado);
    void mostrarEstado();
}
