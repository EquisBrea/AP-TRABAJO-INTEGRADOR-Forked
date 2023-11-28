package org.cursoutn.view;

import org.cursoutn.model.*;

import java.time.LocalDateTime;
import java.util.List;

public class IncidentesView {
    public void mostrarIncidente (int incidenteID, LocalDateTime fechaHoraIncidente, int tiempoNecesario, int esComplejo, IncidenteState estadoIncidente, List<OperadorModel> operadores, ClienteModel cliente, List<TecnicoModel> tecnicos, List<TipoProblemaModel> problemasInvolucrados){
        System.out.println("ID del incidente: "+ incidenteID);
        System.out.println("Fecha y hora registro" + fechaHoraIncidente);
        System.out.println("Tiempo necesario para resolucion: " + tiempoNecesario);
        System.out.println("Es complejo: " + isTrue(esComplejo));
        System.out.println("Estado incidente: " + estadoIncidente);
        System.out.println("Operadores: " + operadores);
        System.out.println("Cliente: " + cliente);
        System.out.println("Tecnicos: " + tecnicos);
        System.out.println("Tipo de problema: " + problemasInvolucrados);
    }

    private boolean isTrue(int esComplejo) {
        return esComplejo >=1;
    }

}
