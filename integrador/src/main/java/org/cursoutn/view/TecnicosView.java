package org.cursoutn.view;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.IncidenteModel;

import java.util.List;

public class TecnicosView {
    public void mostrarTecnico (int tecnicoId, String nombreTecnico, /*List<IncidenteModel> incidentes,*/ List<EspecialidadModel> especialidades) {
        System.out.println("ID del tecnico: " + tecnicoId);
        System.out.println("Nombre del Tecnico: " + nombreTecnico);
 //       System.out.println("Incidentes afectados: " + incidentes );
        System.out.println("Especialidades: " + especialidades);
    }
}
