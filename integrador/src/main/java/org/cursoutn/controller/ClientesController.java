package org.cursoutn.controller;

import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.view.ClientesView;

import java.util.List;

public class ClientesController {
    public ClienteModel model;
    public ClientesView view;
    public JpaClienteRepository repository;

    public ClientesController(ClienteModel model, ClientesView view) {
        this.model = model;
        this.view = view;
    }
    public void guardarCliente (ClienteModel cliente) throws Exception {
        repository.guardarCliente(cliente);
    }
    public ClienteModel obtenerClientePorId(Integer id) throws Exception {
        return repository.obtenerClientePorId(id);
    }
    public void actualizarCliente(ClienteModel cliente) throws Exception {
        repository.actualizarCliente(cliente);
    }
    public void eliminarCliente(ClienteModel cliente) throws Exception {repository.eliminarCliente(cliente);}

    public void setRazonSocialCliente(String razonSocialCliente) throws Exception {
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
    public void setNotificaciones(List<NotificacionModel> notificacion){
        model.setNotificaciones(notificacion);
    }
    public void agregarNotificacion (String nombreNotificacion){
        NotificacionModel notif = new NotificacionModel();
        notif.setNombreNotificacion(nombreNotificacion);
        model.getNotificaciones().add(notif);
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
