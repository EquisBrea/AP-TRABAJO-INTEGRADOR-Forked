package org.cursoutn.controller;

import org.cursoutn.model.ServicioModel;
import org.cursoutn.view.ServiciosView;

public class ServiciosController {
    private ServicioModel model;
    private ServiciosView view;

    public ServiciosController(ServicioModel model, ServiciosView view) {
        this.model = model;
        this.view = view;
    }
}
