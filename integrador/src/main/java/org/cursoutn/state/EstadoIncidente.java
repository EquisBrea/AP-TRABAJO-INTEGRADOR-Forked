package org.cursoutn.state;

import org.cursoutn.model.IncidenteModel;

public interface EstadoIncidente {

    void iniciar(IncidenteModel incidente);
    void enCurso(IncidenteModel incidente);
    void finalizar(IncidenteModel incidente);

}
