package org.cursoutn.controller;

import org.cursoutn.model.NotificacionModel;
import org.cursoutn.view.NotificacionView;

public class NotificacionController {
    private NotificacionModel model;
    private NotificacionView view;

    public NotificacionController(NotificacionModel model, NotificacionView view) {
        this.model = model;
        this.view = view;
    }
}
