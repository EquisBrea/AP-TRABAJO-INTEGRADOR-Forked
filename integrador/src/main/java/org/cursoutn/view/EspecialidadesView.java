package org.cursoutn.view;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.TecnicoModel;

import java.util.List;

public class EspecialidadesView {
    public void mostrarDetallesEspecialidad (int especialidadId, String nombreEspecialidad, List<TecnicoModel> listadoTecnicos){
        System.out.println("ID de especialidad: "+ especialidadId);
        System.out.println("Nombre Especialidad: " + nombreEspecialidad);
        System.out.println("Tecnicos habilitados: " + listadoTecnicos.stream().toString());
    }
}
