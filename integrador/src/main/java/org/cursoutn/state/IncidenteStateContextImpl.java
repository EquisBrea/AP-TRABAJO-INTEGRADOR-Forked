package org.cursoutn.state;

import org.cursoutn.model.IncidenteModel;

public class IncidenteStateContextImpl implements IncidenteStateContext {

    private EstadoIncidente estado;
    private IncidenteModel incidente;

    @Override
    public void setState(EstadoIncidente estado) {
        this.estado = estado;
    }

    @Override
    public void iniciar() {
        this.incidente.setEstadoIncidenteActual(new EstadoIniciado());
    }

    @Override
    public void enCurso() {
        this.incidente.setEstadoIncidenteActual(new EstadoEnCurso());
    }

    @Override
    public void finalizar() {
    this.incidente.setEstadoIncidenteActual(new EstadoFinalizado());
    }
}
