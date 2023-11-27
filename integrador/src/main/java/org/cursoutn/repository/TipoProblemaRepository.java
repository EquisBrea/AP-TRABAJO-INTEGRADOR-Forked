package org.cursoutn.repository;

import org.cursoutn.model.TipoProblemaModel;

import java.util.List;

public interface TipoProblemaRepository {

    public List<TipoProblemaModel> obtenerTodosLosTipoProblema() throws Exception;

    public void guardarTipoProblema(TipoProblemaModel tipoProblema) throws Exception;

    public TipoProblemaModel obtenerTipoProblemaPorId(int id) throws Exception;

    public void actualizarTipoProblema(TipoProblemaModel tipoProblema) throws Exception;

    public void eliminarTipoProblema(TipoProblemaModel tipoProblema) throws Exception;
}
