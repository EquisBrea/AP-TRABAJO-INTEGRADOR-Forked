package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;
import jakarta.persistence.EntityManager;
import org.cursoutn.controller.ClientesController;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.view.ClientesView;

import java.util.List;
import java.util.Properties;
import java.util.Scanner;


public class Main {


    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
   // public static ClientesController abrirCliente(){

     //   return clienteController;
    //}
   /* public static void registrarNuevoCliente(ClientesController clientesController){
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


   /* public static void mostrarInfo(Process process, List<String> datos){
        ClientesController cliente = abrirCliente();
        cliente.actualizarView();
        }
    */



    public static void main(String[] args) {
        /*EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //ClienteModel cliente = new ClienteModel();
        //ClientesView clientesView = new ClientesView();
        //ClientesController clienteController = new ClientesController(cliente, clientesView); //← Seteamos todos los atributos em.persist(empleado);
        tx.commit();*/

        Menu menu = new Menu();

        try {
            menu.menuInicial();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}



