package org.cursoutn.view;

import org.cursoutn.controller.IncidentesController;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;

import java.util.List;

public class ClientesView {
    public void mostrarDetallesCliente (int clienteId, String razonSocial, List<NotificacionModel> notificaciones, List<ServicioModel> servicios, List<IncidenteModel> incidentes){
        System.out.println("ID del cliente: "+ clienteId);
        System.out.println("Razón social: " + razonSocial);
        System.out.println("Tipo de notificacion preferida: " + notificaciones.stream().toString());
        System.out.println("Servicios contratados: " + servicios.stream().toString());
        System.out.println("Incidentes reportados: " + incidentes.stream().toString());
    }
}
