package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.controller.ClientesController;
import org.cursoutn.controller.IncidentesController;
import org.cursoutn.controller.TecnicosController;
import org.cursoutn.model.*;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.repository.JpaIncidenteRepository;
import org.cursoutn.repository.JpaTecnicoRepository;
import org.cursoutn.state.IncidenteAbierto;
import org.cursoutn.state.IncidenteEstado;
import org.cursoutn.state.IncidenteState;
import org.cursoutn.view.ClientesView;
import org.cursoutn.view.IncidentesView;
import org.cursoutn.view.TecnicosView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Crear {
    public static void registrarNuevoCliente() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            ClienteModel cliente = new ClienteModel("cliente", (long) 0, new ArrayList<NotificacionModel>(), new ArrayList<ServicioModel>(), new ArrayList<IncidenteModel>());
            ClientesView clientesView = new ClientesView();
            JpaClienteRepository repository = new JpaClienteRepository();
            ClientesController clienteController = new ClientesController(cliente, clientesView);
            clienteController.repository = repository;

            Scanner scn = new Scanner(System.in);

            System.out.println("Ingrese Razon Social:");
            String txt = scn.nextLine();
            clienteController.setRazonSocialCliente(txt);

            System.out.println("Ingrese Cuil:");
            long cuil = scn.nextLong();
            clienteController.setCuilCliente(cuil);

            System.out.println("Ingrese modo de comunicación preferido: ");
            String nottxt = scn.nextLine();
            clienteController.agregarNotificacion(nottxt);

            clienteController.repository.actualizarCliente(clienteController.model);

        } catch (Exception e) {
            System.out.println("Error al crear nuevo registro: \n" + e);
        }
    }
    public static void registrarNuevoTecnico() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            TecnicoModel tecnico = new TecnicoModel("cliente", 1, new ArrayList<IncidenteModel>(), new ArrayList<EspecialidadModel>());
            TecnicosView tecnicosView = new TecnicosView();
            JpaTecnicoRepository repository = new JpaTecnicoRepository();
            TecnicosController tecnicosController = new TecnicosController(tecnico, tecnicosView);
            tecnicosController.repository = repository;

            Scanner scn = new Scanner(System.in);

            System.out.println("Ingrese Razon Social:");
            String txt = scn.nextLine();
            tecnicosController.setNombreTecnico(txt);

            System.out.println("Ingrese Cuil:");
            long cuil = scn.nextLong();

            System.out.println("Ingrese especialidad: ");
            String nottxt = scn.nextLine();
            tecnicosController.agregarEspecialidad(nottxt);

            tecnicosController.repository.actualizarTecnico(tecnicosController.model);

        } catch (Exception e) {
            System.out.println("Error al crear nuevo registro: \n" + e);
        }
    }
    public static void menuRegistrarIncidente() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            IncidenteModel i = new IncidenteModel(LocalDateTime.now(), 1, 0, new IncidenteEstado(), new ArrayList<OperadorModel>(), new ClienteModel(), new ArrayList<TecnicoModel>(), new ArrayList<TipoProblemaModel>());
            IncidentesView incidentesView = new IncidentesView();
            JpaIncidenteRepository repository = new JpaIncidenteRepository();
            IncidentesController control = new IncidentesController(i, incidentesView);

            Scanner teclado = new Scanner(System.in);
            System.out.println ("Por favor ingrese el id del cliente:");
            int clienteId = teclado.nextInt();
            System.out.println ("Ingrese problemas involucrados en incidente:");


            control.setFechaHoraIncidente(LocalDateTime.now());
            control.setEsComplejo(0);
        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }


    }

}
