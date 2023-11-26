package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.cursoutn.packageModel.ClientesModel;

public class Main {

    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    private static void saludarAlMundo () {
        /* System.out.println("Hello world!");
        ClientesModel cliente1 = new ClientesModel();
        cliente1.setName("Roberto");
        System.out.println("Hello, " + cliente1.getName()+ "!");

         */
    }
    public static void main(String[] args) {
        saludarAlMundo();
    }
}