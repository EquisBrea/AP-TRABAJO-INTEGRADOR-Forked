package org.cursoutn.controller;

import lombok.Getter;
import lombok.Setter;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.view.ClientesView;

public class ClientesController {
    private ClienteModel model;
    private ClientesView view;

    public ClientesController(ClienteModel model, ClientesView view) {
        this.model = model;
        this.view = view;
    }
}
