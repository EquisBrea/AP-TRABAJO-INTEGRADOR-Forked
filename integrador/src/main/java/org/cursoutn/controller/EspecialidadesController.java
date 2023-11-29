package org.cursoutn.controller;

import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.TecnicoModel;
import org.cursoutn.repository.JpaEspecialidadRepository;
import org.cursoutn.view.EspecialidadesView;
import org.cursoutn.view.TecnicosView;

import java.util.List;

public class EspecialidadesController {
    private EspecialidadModel model;
    private EspecialidadesView view;
    public JpaEspecialidadRepository repository;

    public EspecialidadesController(EspecialidadModel model, EspecialidadesView view) {
        this.model = model;
        this.view = view;
    }
    public void setEspecialidadId(int especialidadId) {
        this.model.setId(especialidadId);
    }
    public Integer getEspecialidadId(){
        return this.model.getId();
    }
    public void setNombreEspecialidad (String nombreEspecialidad){
        this.model.setNombreEspecialidad(nombreEspecialidad);
    }
    public String getNombreEspecialidad (){
        return this.model.getNombreEspecialidad();
    }
    public void setListadoTecnicos (List<TecnicoModel> listadoTecnicos){this.model.setTecnicos(listadoTecnicos);}
    public void agregarTecnico (String nombreTecnico){
        TecnicoModel notif = new TecnicoModel();
        notif.setNombreTecnico(nombreTecnico);
        model.getTecnicos().add(notif);
    }
    public List<TecnicoModel> listadoTecnicos() {
        return this.model.getTecnicos();
    }
    public List<EspecialidadModel> obtenerTodasLasEspecialidades() throws Exception {
        return repository.obtenerTodasLasEspecialidades();
    }
    public void guardarEspecialidad(EspecialidadModel especialidadModel) throws Exception {
        repository.guardarEspecialidad(especialidadModel);
    }
    public EspecialidadModel obtenerEspecialidadPorId (int id) throws Exception {
        return repository.obtenerEspecialidadPorId(id);
    }
    public void actualizarEspecialidad(EspecialidadModel especialidadModel) throws Exception {
        repository.actualizarEspecialidad(especialidadModel);
    }
    public void eliminarEspecialidad (EspecialidadModel especialidadModel) throws Exception {
        repository.eliminarEspecialidad(especialidadModel);
    }
    public void actualizarView(){
        view.mostrarDetallesEspecialidad(this.model.getId(), this.model.getNombreEspecialidad(), this.model.getTecnicos());
    }
}
