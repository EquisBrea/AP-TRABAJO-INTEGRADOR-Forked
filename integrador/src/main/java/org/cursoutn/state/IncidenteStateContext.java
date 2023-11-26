package org.cursoutn.state;

public interface IncidenteStateContext {

    void setState(EstadoIncidente estado);
    void iniciar();
    void enCurso();
    void finalizar();

}
