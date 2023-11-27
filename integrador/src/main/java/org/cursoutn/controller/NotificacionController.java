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
    public void setNotificacionId(int notificacionId){this.model.setId(notificacionId);}
    public int getNotificacionId(){return this.model.getId();}
    public void setNombreNotificacion(String nombreNotificacion){this.model.setNombreNotificacion(nombreNotificacion);}
    public String getNombreNotificacion (){return this.model.getNombreNotificacion();}
    public void actualizarView (){
        view.mostrarNotificacionesPreferidas(this.model.getId(), this.model.getNombreNotificacion());
    }
}
