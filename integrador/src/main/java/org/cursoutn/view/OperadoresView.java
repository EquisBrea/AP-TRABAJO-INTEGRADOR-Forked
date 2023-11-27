package org.cursoutn.view;

import org.cursoutn.model.IncidenteModel;

import java.util.List;

public class OperadoresView {
    public void mostrarOperador (int operadorId, String nombreOperador, List<IncidenteModel> listadoIncidentes){
        System.out.println("ID operador: " + operadorId);
        System.out.println("Nombre operador: " + nombreOperador);
        System.out.println("Incidentes administrados: " + listadoIncidentes);
    }
}
