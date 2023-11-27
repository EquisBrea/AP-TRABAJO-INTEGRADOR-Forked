package org.cursoutn.view;

import org.cursoutn.model.IncidenteModel;

import java.util.List;

public class EstadoIncidenteView {
    public void mostrarEstadoIncidente (int id, String descripcionEstado, List<IncidenteModel> listadoIncidentes){
        System.out.println("ID del estado: "+ descripcionEstado);
        System.out.println("Descripcion estado: " + descripcionEstado);
        System.out.println("Incidentes en situacion: " + listadoIncidentes.stream().toString());
    }
}
