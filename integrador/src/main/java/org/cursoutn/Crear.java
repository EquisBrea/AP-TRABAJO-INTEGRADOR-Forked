package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Subgraph;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.cursoutn.controller.*;
import org.cursoutn.model.*;
import org.cursoutn.repository.*;
import org.cursoutn.state.IncidenteEstado;
import org.cursoutn.state.State;
import org.cursoutn.view.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

            scn.nextLine();

            System.out.println("Ingrese modo de comunicación preferido: ");
            String ntxt = scn.nextLine();
            clienteController.agregarNotificacion(ntxt);

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
            String nottxt = scn.nextLine().toUpperCase();
            if (!Consultas.existeEspecialidad(nottxt)){
                Crear.registrarNuevaEspecialidad();
            }

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

            JpaClienteRepository clienteRepository = new JpaClienteRepository();

            JpaTecnicoRepository tecnicoRepository = new JpaTecnicoRepository();

            Scanner teclado = new Scanner(System.in);
            System.out.println ("Por favor ingrese el id del cliente:");
            int clienteId = teclado.nextInt();
            ClienteModel cM = clienteRepository.obtenerClientePorId(clienteId);

            teclado.nextLine();

            System.out.println ("Ingrese problemas involucrados en incidente:");
            String tp = teclado.nextLine();
            System.out.println(Consultas.existeTipoDeProblema(tp));

            if (!Consultas.existeTipoDeProblema(tp)) {
                System.out.println("Problema no existente con anterioridad, por favor registrar: ");
                Crear.registrarNuevoTipoDeProblema();
            }

            control.setCliente(cM);
            control.setEstadoIncidenteActual(State.INICIADO);
            repository.actualizarIncidente(control.model);
        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }


    }

    private static void registrarNuevoTipoDeProblema() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            TipoProblemaModel p = new TipoProblemaModel(new ArrayList<>(), new ServicioModel());
            TipoProblemaView tipoProblemaView = new TipoProblemaView();
            List listaDeIncidentes = new ArrayList<>();
            
            IncidenteModel incidenteModel = new IncidenteModel();
            listaDeIncidentes.add(incidenteModel);
            JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();
            TipoProblemaController control = new TipoProblemaController(p, tipoProblemaView);


            Scanner teclado = new Scanner(System.in);

            System.out.println ("Ingrese tipo de problema:");
            String desc = teclado.nextLine();

            control.setIncidentes(listaDeIncidentes);
            control.setNombreTipoProblema(desc);
            repository.actualizarTipoProblema(control.model);

        } catch (Exception e) {
            System.out.println("Problema grave: " + e);
        }

    }

    public static void registrarNuevaEspecialidad() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            EspecialidadModel i = new EspecialidadModel("Especialidad nueva", new ArrayList<TecnicoModel>(), new TipoProblemaModel());
            EspecialidadesView incidentesView = new EspecialidadesView();
            JpaEspecialidadRepository repository = new JpaEspecialidadRepository();
            EspecialidadesController control = new EspecialidadesController(i, incidentesView);

            control.repository = repository;

            Scanner teclado = new Scanner(System.in);
            System.out.println ("Describir especialidad: ");
            String desc = teclado.nextLine();

            System.out.println ("Describir tipo problema: ");
            String descpr = teclado.nextLine();
            if (!Consultas.existeTipoDeProblema(descpr)){
                Crear.registrarNuevoTipoDeProblema();
            }

            control.setNombreEspecialidad(desc);
            control.setListadoTecnicos(new ArrayList<>());

            control.repository.actualizarEspecialidad(i);

        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }
    }

}
