package org.cursoutn.repository;

import org.cursoutn.model.TecnicoModel;

import java.util.List;

public interface TecnicoRepository {

    public List<TecnicoModel> obtenerTodosLosTecnicos();

    public void guardarTecnico(TecnicoModel tecnico);

    public TecnicoModel obtenerTecnicoPorId(int id);

    public void actualizarTecnico(TecnicoModel tecnico);

    public void eliminarTecnico(TecnicoModel tecnico);



}
