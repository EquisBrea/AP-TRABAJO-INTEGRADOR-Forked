package org.cursoutn.controller;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.TecnicoModel;
import org.cursoutn.view.EspecialidadesView;
import org.cursoutn.view.TecnicosView;

import java.util.List;

public class EspecialidadesController {
    private EspecialidadModel model;
    private EspecialidadesView view;

    public EspecialidadesController(EspecialidadModel model, EspecialidadesView view) {
        this.model = model;
        this.view = view;
    }
    public void setEspecialidadId(int especialidadId) {
        this.model.setId(especialidadId);
    }
    public int getEspecialidadId(){
        return this.model.getId();
    }
    public void setNombreEspecialidad (String nombreEspecialidad){
        this.model.setNombreEspecialidad(nombreEspecialidad);
    }
    public String getNombreEspecialidad (){
        return this.model.getNombreEspecialidad();
    }
    public void setListadoTecnicos (TecnicoModel tecnico){this.model.getTecnicos().add(tecnico);}
    public List<TecnicoModel> listadoTecnicos() {
        return this.model.getTecnicos();
    }
    public void actualizarView(){
        view.mostrarDetallesEspecialidad(this.model.getId(), this.model.getNombreEspecialidad(), this.model.getTecnicos());
    }
}
