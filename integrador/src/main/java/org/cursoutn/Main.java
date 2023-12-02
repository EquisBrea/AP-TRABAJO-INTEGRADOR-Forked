package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.cursoutn.GUI.VentanaInicio;

import javax.swing.*;


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

        SwingUtilities.invokeLater(() ->
                new VentanaInicio());

        try {
            menu.showMenu();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    

}



