package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.cursoutn.controller.IncidentesController;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.view.IncidentesView;

public class Main {

    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    private static void saludarAlMundo () {
        /* System.out.println("Hello world!");
        ClienteModel cliente1 = new ClienteModel();
        cliente1.setName("Roberto");
        System.out.println("Hello, " + cliente1.getName()+ "!");
         */
        IncidenteModel model = new IncidenteModel();
        IncidentesView view = new IncidentesView();
        IncidentesController nuevoIncidente = new IncidentesController(model, view);
    }
    public static void main(String[] args) {
        saludarAlMundo();
    }
}