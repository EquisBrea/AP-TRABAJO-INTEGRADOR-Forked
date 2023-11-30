package org.cursoutn.view;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.IncidenteModel;

import java.util.List;

public class TipoProblemaView {
    public void mostrarTipoProblema (int problemaId, String nombreProblema/*, List<IncidenteModel> incidentes, List<EspecialidadModel> especialidades*/){
        System.out.println("ID del tipo de problema: "+ problemaId);
        System.out.println("Nombre del tipo de problema: " + nombreProblema);
        //System.out.println("Incidentes con este tipo de problema: "+ incidentes);
        //System.out.println("Especialidades que lo pueden resolver: "+ especialidades);
    }
}
