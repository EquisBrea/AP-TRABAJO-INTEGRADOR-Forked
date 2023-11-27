package org.cursoutn.controller;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.TecnicoModel;
import org.cursoutn.view.TecnicosView;

public class TecnicosController {
    private TecnicoModel model;
    private TecnicosView view;

    public TecnicosController(TecnicoModel model, TecnicosView view) {
        this.model = model;
        this.view = view;
    }
    public void setTecnicoId (int tecnicoId){this.model.setId(tecnicoId);}
    public void setNombreTecnico(String nombreTecnico){this.model.setNombreTecnico(nombreTecnico);}
    public void setIncidentes(IncidenteModel incidentes){this.model.getIncidentes().add(incidentes);}
    public void setEspecialidades(EspecialidadModel especialidad){this.model.getEspecialidades().add(especialidad);}
    public void actualizarView (){
        view.mostrarTecnico(this.model.getId(),this.model.getNombreTecnico(),this.model.getIncidentes(),this.model.getEspecialidades());
    }
}
