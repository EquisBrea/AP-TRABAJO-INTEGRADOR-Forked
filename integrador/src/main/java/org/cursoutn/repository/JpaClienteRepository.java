package org.cursoutn.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.cursoutn.model.ClienteModel;

import java.util.List;

public class JpaClienteRepository implements ClienteRepository{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<ClienteModel> obtenerTodosLosClientes() {
        return entityManager.createQuery("SELECT c FROM ClienteModel c", ClienteModel.class).getResultList();
    }

    @Override
    public void guardarCliente(ClienteModel cliente) throws Exception{
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Se produjo un error, tus cambios no fueron guardados");
        }
    }

    @Override
    public ClienteModel obtenerClientePorId(int id) {
        return entityManager.find(ClienteModel.class, id);
    }

    @Override
    public void actualizarCliente(ClienteModel cliente) {
        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminarCliente(ClienteModel cliente) {

    }
}
