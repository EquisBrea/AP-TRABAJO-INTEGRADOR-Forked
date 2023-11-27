package org.cursoutn.controller;

import org.cursoutn.model.TecnicoModel;
import org.cursoutn.view.TecnicosView;

public class TecnicosController {
    private TecnicoModel model;
    private TecnicosView view;

    public TecnicosController(TecnicoModel model, TecnicosView view) {
        this.model = model;
        this.view = view;
    }
}
