package org.cursoutn.controller;

import org.cursoutn.model.ServicioModel;
import org.cursoutn.model.TipoProblemaModel;
import org.cursoutn.view.ServiciosView;

import java.util.List;

public class ServiciosController {
    private ServicioModel model;
    private ServiciosView view;

    public ServiciosController(ServicioModel model, ServiciosView view) {
        this.model = model;
        this.view = view;
    }
    public void setServicioId (int servicioId){this.model.setId(servicioId);}
    public Integer getServicioId (){return this.model.getId();}
    public void setNombreServicio (String nombreServicio){this.model.setNombreServicio(nombreServicio);}
    public String getNombreServicio(){return this.model.getNombreServicio();}
  //  public void setProblema(TipoProblemaModel tipoProblema){this.model.getTiposDeProblemas().add(tipoProblema);}
   // public List<TipoProblemaModel> getProblemas (){return this.model.getTiposDeProblemas();}
    public void actualizarView (){
        view.mostrarServicios(this.model.getId(),this.model.getNombreServicio()/*, this.model.getTiposDeProblemas()*/);
    }
}
