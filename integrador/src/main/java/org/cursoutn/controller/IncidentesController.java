package org.cursoutn.controller;

import org.cursoutn.model.IncidenteModel;
import org.cursoutn.view.IncidentesView;

public class IncidentesController {
    private IncidenteModel model;
    private IncidentesView view;

    public IncidentesController(IncidenteModel model, IncidentesView view) {
        this.model = model;
        this.view = view;
    }

}
