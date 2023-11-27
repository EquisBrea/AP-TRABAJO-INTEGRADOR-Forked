package org.cursoutn.repository;

import org.cursoutn.model.TecnicoModel;

import java.util.List;

public interface TecnicoRepository {

    public List<TecnicoModel> obtenerTodosLosTecnicos() throws Exception;

    public void guardarTecnico(TecnicoModel tecnico) throws Exception;

    public TecnicoModel obtenerTecnicoPorId(int id) throws Exception;

    public void actualizarTecnico(TecnicoModel tecnico) throws Exception;

    public void eliminarTecnico(TecnicoModel tecnico) throws Exception;



}
