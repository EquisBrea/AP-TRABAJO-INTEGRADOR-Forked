package org.cursoutn.controller;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.view.EspecialidadesView;

public class EspecialidadesController {
    private EspecialidadModel model;
    private EspecialidadesView view;

    public EspecialidadesController(EspecialidadModel model, EspecialidadesView view) {
        this.model = model;
        this.view = view;
    }
}
