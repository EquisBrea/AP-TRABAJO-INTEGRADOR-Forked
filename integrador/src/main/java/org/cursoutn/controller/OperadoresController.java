package org.cursoutn.controller;

import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.OperadorModel;
import org.cursoutn.view.OperadoresView;

import java.util.List;

public class OperadoresController {
    private OperadorModel model;
    private OperadoresView view;

    public OperadoresController(OperadorModel model, OperadoresView view) {
        this.model = model;
        this.view = view;
    }
    public void setOperadorId (int operadorId){this.model.setId(operadorId);}
    public int getOperadorId(){return this.model.getId();}
    public void setNombreOperador(String nombreOperador){this.model.setNombreOperador(nombreOperador);}
    public String getNombreOperador(){return this.model.getNombreOperador();}
    public void setIncidentes(IncidenteModel incidentes){this.model.getIncidentes().add(incidentes);}
    public List<IncidenteModel> getIncidentes(){return this.model.getIncidentes();}
    public void actualizarView (){
        view.mostrarOperador(this.model.getId(), this.model.getNombreOperador(), this.model.getIncidentes());
    }
}
