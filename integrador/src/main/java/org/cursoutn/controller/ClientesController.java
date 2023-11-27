package org.cursoutn.controller;

import lombok.Getter;
import lombok.Setter;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;
import org.cursoutn.view.ClientesView;

import java.util.List;
import java.util.Set;

public class ClientesController {
    private ClienteModel model;
    private ClientesView view;

    public ClientesController(ClienteModel model, ClientesView view) {
        this.model = model;
        this.view = view;
    }
    public void setClienteId (int clienteId){
        model.setId(clienteId);
    }
    public int getClienteId(){
        return model.getId();
    }
    public void setRazonSocialCliente(String razonSocialCliente){
        model.setRazon_social(razonSocialCliente);
    }
    public String getRazonSocialCliente (){
        return model.getRazon_social();
    }
    public void setCuilCliente (long cuilCliente) {
        model.setCuil(cuilCliente);
    }
    public long getCuilCliente (){
        return model.getCuil();
    }
    public void setNotificaciones(NotificacionModel notificacion){
        model.getNotificaciones().add(notificacion);
    }
    public String getNotificaciones(){
        return model.getNotificaciones().stream().toString();
    }
    public void setServicios(ServicioModel servicio){
        model.setServicio().add(servicio);
    }
}
