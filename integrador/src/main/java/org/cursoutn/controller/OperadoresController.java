package org.cursoutn.controller;

import org.cursoutn.model.OperadorModel;
import org.cursoutn.view.OperadoresView;

public class OperadoresController {
    private OperadorModel model;
    private OperadoresView view;

    public OperadoresController(OperadorModel model, OperadoresView view) {
        this.model = model;
        this.view = view;
    }
}
