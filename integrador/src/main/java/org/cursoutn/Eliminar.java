package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.controller.ClientesController;
import org.cursoutn.model.ClienteModel;
import org.cursoutn.model.IncidenteModel;
import org.cursoutn.model.NotificacionModel;
import org.cursoutn.model.ServicioModel;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.view.ClientesView;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Eliminar {
    public static void borrarCliente (){
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaClienteRepository repository = new JpaClienteRepository();

        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Borrar todos?:");
            String respuesta = scn.nextLine();
            switch(respuesta){
                case ("y"):
                    repository.obtenerTodosLosClientes().forEach((numero) -> {
                        try {
                            repository.eliminarCliente(numero);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                case("Y"):
                    repository.obtenerTodosLosClientes().forEach((numero) -> {
                        try {
                            repository.eliminarCliente(numero);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
                default:
                    break;
            }
            System.out.println("Ingrese id:");
            int id = scn.nextInt();
            repository.eliminarCliente(repository.obtenerClientePorId(id));
        } catch (Exception e) {
            System.out.println("Error al crear nuevo registro: \n" + e);
        }
    }

    public static void borrarTecnico() {
    }

    public static void borrarEspecialidad() {
    }
}

