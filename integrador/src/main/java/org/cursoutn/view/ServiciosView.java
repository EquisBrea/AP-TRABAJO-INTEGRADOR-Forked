package org.cursoutn.view;

import org.cursoutn.model.EspecialidadModel;

import java.util.List;

public class ServiciosView {
    public void mostrarServicios (int servicioID, String nombreServicio, List<EspecialidadModel> especialidades) {
        System.out.println("ID servicio: " + servicioID);
        System.out.println("Nombre del servicio: " + nombreServicio);
        System.out.println("Listado de especialidades: " + especialidades);
    }
}
