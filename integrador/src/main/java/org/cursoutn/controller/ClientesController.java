package org.cursoutn.controller;

import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;
import org.cursoutn.view.ClientesView;

import java.util.List;

public class ClientesController {
    public ClienteModel model;
    private ClientesView view;

    public ClientesController(ClienteModel model, ClientesView view) {
        this.model = model;
        this.view = view;
    }

    public void setClienteId (int clienteId){
        model.setId(clienteId);
    }
    public Integer getClienteId(){
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
    public Long getCuilCliente (){
        return model.getCuil();
    }
    public void setNotificaciones(NotificacionModel notificacion){
        model.getNotificaciones().add(notificacion);
    }
    public List<NotificacionModel> getNotificaciones(){
        return model.getNotificaciones();
    }
   public void setServicios(ServicioModel servicios) {
       model.getServicios().add(servicios);
   }
   public List<ServicioModel> listadoServicios (){
        return this.model.getServicios();
   }
    public void setIncidentes(IncidenteModel incidente){
        model.getIncidentes().add(incidente);
    }
    public List<IncidenteModel> getIncidentes(){
        return model.getIncidentes();
    }
    public void actualizarView() {
        view.mostrarDetallesCliente(model.getId(), model.getRazon_social(), model.getNotificaciones(),
                model.getServicios(), model.getIncidentes());
    }
}
