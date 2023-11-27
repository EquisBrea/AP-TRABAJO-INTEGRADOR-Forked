package org.cursoutn.controller;

import org.cursoutn.model.EstadoIncidenteModel;
import org.cursoutn.state.EstadoIncidente;
import org.cursoutn.view.EstadoIncidenteView;

public class EstadoIncidenteController {
    private EstadoIncidenteModel model;
    private EstadoIncidenteView view;

    public EstadoIncidenteController(EstadoIncidenteModel model, EstadoIncidenteView view) {
        this.model = model;
        this.view = view;
    }
}
