package org.cursoutn.state;

import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.IncidenteState;

public interface EstadoIncidente {
    void cambiarEstado(IncidenteEstado incidenteEstado);

}
