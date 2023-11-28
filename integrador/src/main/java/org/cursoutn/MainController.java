package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.cursoutn.controller.ClientesController;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.view.ClientesView;

import java.util.List;
import java.util.Scanner;

import static org.cursoutn.Main.getEntityManager;

public class MainController {

    public static ClientesController abrirCliente(){
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        ClienteModel cliente = new ClienteModel();
        ClientesView clientesView = new ClientesView();
        ClientesController clienteController = new ClientesController(cliente, clientesView); //← Seteamos todos los atributos em.persist(empleado);
        tx.commit();
        tx.begin();
        return clienteController;
    }
    public static void registrarNuevoCliente(ClientesController clientesController){
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese Razon Social:");
        String txt = scn.nextLine();
        clientesController.setRazonSocialCliente(txt);
        System.out.println("Ingrese Cuil:");
        long cuil = scn.nextLong();
        clientesController.setCuilCliente(cuil);
    }
    public static ClienteModel buscarClientePorId(ClientesController cliente, int id) throws Exception {
        return cliente.model.getRepository().obtenerClientePorId(id);
    }
    public static void mostrarInfo(Process process, List<String> datos){
        ClientesController cliente = abrirCliente();
        cliente.actualizarView();
    }

}
