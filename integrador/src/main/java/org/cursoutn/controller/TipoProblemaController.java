package org.cursoutn.controller;

import org.cursoutn.model.TipoProblemaModel;
import org.cursoutn.view.TipoProblemaView;

public class TipoProblemaController {
    private TipoProblemaModel model;
    private TipoProblemaView view;

    public TipoProblemaController(TipoProblemaModel model, TipoProblemaView view) {
        this.model = model;
        this.view = view;
    }
}
