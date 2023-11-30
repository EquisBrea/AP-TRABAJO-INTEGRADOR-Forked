package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.Main;
import org.cursoutn.MainController;
import org.cursoutn.model.TipoProblemaModel;

import java.util.List;

public class JpaTipoProblemaRepository implements TipoProblemaRepository {

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();

    @Override
    public List<TipoProblemaModel> obtenerTodosLosTipoProblema() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM TipoProblemaModel a", TipoProblemaModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros" + e);
        }
    }

    @Override
    public void guardarTipoProblema(TipoProblemaModel tipoProblema) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tipoProblema);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados" + e);
        }
    }

    @Override
    public TipoProblemaModel obtenerTipoProblemaPorId(int id) throws Exception {
        try {
            return entityManager.find(TipoProblemaModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado" + e);
        }
    }

    @Override
    public void actualizarTipoProblema(TipoProblemaModel tipoProblema) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tipoProblema);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar el registro" + e);
        }
    }

    @Override
    public void eliminarTipoProblema(TipoProblemaModel tipoProblema) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(tipoProblema) ? tipoProblema : entityManager.merge(tipoProblema));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro" + e);
        }
    }
}
