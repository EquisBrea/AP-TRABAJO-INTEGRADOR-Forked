package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.Main;
import org.cursoutn.model.TecnicoModel;

import java.util.List;

public class JpaTecnicoRepository implements TecnicoRepository {

    @PersistenceContext
    private EntityManager entityManager = Main.getEntityManager();

    @Override
    public List<TecnicoModel> obtenerTodosLosTecnicos() throws Exception {
        try{
            return entityManager.createQuery("SELECT a FROM TecnicoModel a", TecnicoModel.class).getResultList();
        } catch (Exception e) {
            throw new Exception("Error al obtener todos los registros");
        }
    }

    @Override
    public void guardarTecnico(TecnicoModel tecnico) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tecnico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados");
        }
    }

    @Override
    public TecnicoModel obtenerTecnicoPorId(int id) throws Exception {
        try {
            return entityManager.find(TecnicoModel.class, id);
        } catch (Exception e) {
            throw new Exception("Error al obtener el registro solicitado");
        }
    }

    @Override
    public void actualizarTecnico(TecnicoModel tecnico) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(tecnico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al actualizar el registro");
        }
    }

    @Override
    public void eliminarTecnico(TecnicoModel tecnico) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(tecnico) ? tecnico : entityManager.merge(tecnico));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Error al eliminar el registro");
        }
    }
}
