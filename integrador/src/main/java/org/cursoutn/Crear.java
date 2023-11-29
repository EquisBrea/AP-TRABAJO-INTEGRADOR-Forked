package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.controller.*;
import org.cursoutn.model.*;
import org.cursoutn.repository.*;
import org.cursoutn.state.IncidenteEstado;
import org.cursoutn.state.State;
import org.cursoutn.view.*;

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
            TecnicoModel t = new TecnicoModel("cliente", 1, new ArrayList<IncidenteModel>(), new ArrayList<EspecialidadModel>());
            TecnicosView tecnicosView = new TecnicosView();
            JpaTecnicoRepository repository = new JpaTecnicoRepository();
            TecnicosController tC = new TecnicosController(t, tecnicosView);
            tC.repository = repository;

            Scanner scn = new Scanner(System.in);

            System.out.println("Nombre:");
            String txt = scn.nextLine();
            tC.setNombreTecnico(txt);

            System.out.println("Ingrese horas extras estimadas:");
            long cuil = scn.nextLong();

            System.out.println("Ingrese especialidad: ");
            String nottxt = scn.nextLine();

            tC.setNombreTecnico(txt);
            tC.agregarEspecialidad(nottxt);

            tC.repository.actualizarTecnico(tC.model);

        } catch (Exception e) {
            System.out.println("Error al crear nuevo registro: \n" + e);
        }
    }
    public static void menuRegistrarIncidente() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            IncidenteModel i = new IncidenteModel(LocalDateTime.now(), 1, 0, State.INICIADO, new ArrayList<OperadorModel>(), new ClienteModel(), new ArrayList<TecnicoModel>(), new ArrayList<TipoProblemaModel>());
            IncidentesView incidentesView = new IncidentesView();
            JpaIncidenteRepository repository = new JpaIncidenteRepository();
            IncidentesController control = new IncidentesController(i, incidentesView);

            Scanner teclado = new Scanner(System.in);
            System.out.println ("Por favor ingrese el id del cliente:");
            int clienteId = teclado.nextInt();
            System.out.println ("Ingrese problemas involucrados en incidente:");
            String tp = teclado.nextLine().toUpperCase();
            if (!Consultas.existeTipoDeProblema(tp));

            System.out.println("Problema no existente con anterioridad, por favor registrar: ");
            Crear.registrarNuevoTipoDeProblema();



            control.setFechaHoraIncidente(LocalDateTime.now());
            control.setEsComplejo(0);
        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }


    }

    private static void registrarNuevoTipoDeProblema() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            TipoProblemaModel i = new TipoProblemaModel(new ArrayList<EspecialidadModel>(), new ServicioModel());
            TipoProblemaView incidentesView = new TipoProblemaView();
            JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();
            TipoProblemaController control = new TipoProblemaController(i, incidentesView);

            Scanner teclado = new Scanner(System.in);

            System.out.println ("Ingrese descripcion problema:");
            String desc = teclado.nextLine();

            System.out.println ("Especialidades que lo atienden:");
            String espec = teclado.nextLine();
            if(!Consultas.existeEspecialidad(espec)) {
                Crear.registrarNuevaEspecialidad();
            };

        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }

    }

    private static void registrarNuevaEspecialidad() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            EspecialidadModel i = new EspecialidadModel("Especialidad nueva", new ArrayList<TecnicoModel>(), new TipoProblemaModel());
            EspecialidadesView incidentesView = new EspecialidadesView();
            JpaEspecialidadRepository repository = new JpaEspecialidadRepository();
            EspecialidadesController control = new EspecialidadesController(i, incidentesView);

            Scanner teclado = new Scanner(System.in);

            System.out.println ("Ingrese descripcion problema:");
            String desc = teclado.nextLine();

            System.out.println ("Tecnicos que lo atienden (inserte id):");
            String idtec = teclado.nextLine();
            if(!Consultas.existeTecnicoParaEspecialidad(i)){
                System.out.println("No existen técnicos para esta especialidad.");
            };


        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }
    }

}
