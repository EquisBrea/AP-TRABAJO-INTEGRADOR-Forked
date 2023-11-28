package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.controller.ClientesController;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.view.ClientesView;

import static org.cursoutn.Main.getEntityManager;

public class MainController {
    public static ClienteModel buscarClientePorId(int id) throws Exception {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        ClienteModel cliente = new ClienteModel();
        ClientesView clientesView = new ClientesView();
        ClientesController clienteController = new ClientesController(cliente, clientesView); //← Seteamos todos los atributos em.persist(empleado);
        tx.commit();
        tx.begin();
        return clienteController.model.getRepository().obtenerClientePorId(id);
    }
}
