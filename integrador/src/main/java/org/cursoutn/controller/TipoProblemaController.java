package org.cursoutn.controller;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.TipoProblemaModel;
import org.cursoutn.view.TipoProblemaView;

public class TipoProblemaController {
    private TipoProblemaModel model;
    private TipoProblemaView view;

    public TipoProblemaController(TipoProblemaModel model, TipoProblemaView view) {
        this.model = model;
        this.view = view;
    }
    public void setTipoProblemaId (int tipoProblemaId){this.model.setId(tipoProblemaId);}
    public void setNombreTipoProblema (String nombreTipoProblema){this.model.setNombreTipoProblema(nombreTipoProblema);}
    public void setIncidentes (IncidenteModel incidentes){this.model.getIncidentes().add(incidentes);}
    public void setEspecialidades (EspecialidadModel especialidades) {this.model.getEspecialidades().add(especialidades);}
    public void actualizarView(){
        view.mostrarTipoProblema(this.model.getId(),this.model.getNombreTipoProblema(), this.model.getIncidentes(), this.model.getEspecialidades());
    }
}
