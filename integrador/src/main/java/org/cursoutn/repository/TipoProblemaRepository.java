package org.cursoutn.repository;

import org.cursoutn.model.TipoProblemaModel;

import java.util.List;

public interface TipoProblemaRepository {

    public List<TipoProblemaModel> obtenerTodosLosTipoProblema();

    public void guardarTipoProblema(TipoProblemaModel tipoProblema);

    public TipoProblemaModel obtenerTipoProblemaPorId(int id);

    public void actualizarTipoProblema(TipoProblemaModel tipoProblema);

    public void eliminarTipoProblema(TipoProblemaModel tipoProblema);
}
