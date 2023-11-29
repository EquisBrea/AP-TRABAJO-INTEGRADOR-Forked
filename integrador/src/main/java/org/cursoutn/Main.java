package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;
import jakarta.persistence.EntityManager;
import org.cursoutn.controller.ClientesController;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.view.ClientesView;

import java.util.*;


public class Main {


    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
   //public static ClientesController abrirCliente(){

    //}

    /*public static ClienteModel buscarClientePorId(ClientesController cliente, int id) throws Exception {
        return cliente.getRepository().obtenerClientePorId(id);
    }


     */

   /* public static void mostrarInfo(Process process, List<String> datos){
        ClientesController cliente = abrirCliente();
        cliente.actualizarView();
        }
    */



    public static void main(String[] args) {

        Menu menu = new Menu();

        try {
            menu.menuInicial();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}



