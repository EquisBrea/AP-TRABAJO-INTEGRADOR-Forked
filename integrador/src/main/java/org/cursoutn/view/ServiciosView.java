package org.cursoutn.view;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.TipoProblemaModel;

import java.util.List;

public class ServiciosView {
    public void mostrarServicios (int servicioID, String nombreServicio, List<TipoProblemaModel> problemas) {
        System.out.println("ID servicio: " + servicioID);
        System.out.println("Nombre del servicio: " + nombreServicio);
        System.out.println("Listado de problemas: " + problemas);
    }
}
