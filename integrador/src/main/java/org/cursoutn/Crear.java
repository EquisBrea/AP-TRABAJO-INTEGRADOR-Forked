package org.cursoutn;

import jakarta.persistence.*;
import org.cursoutn.controller.*;
import org.cursoutn.model.*;
import org.cursoutn.repository.*;
import org.cursoutn.state.State;
import org.cursoutn.view.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.cursoutn.Consultas.devolverArrayDeStrings;

public class Crear {
    @PersistenceContext
    private static EntityManager em;
    public void registrarNuevoCliente() {
        try {
            ClienteModel cliente = new ClienteModel("cliente", (long) 0, new NotificacionModel(), new ArrayList<ServicioModel>(), new ArrayList<IncidenteModel>());
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
            clienteController.setNotificaciones(new NotificacionModel(ntxt));

            clienteController.repository.guardarCliente(clienteController.model);

        } catch (Exception e) {
            System.out.println("Error al crear nuevo registro Cliente: \n" + e);
        }
    }
    public void registrarNuevoTecnico() {
           try {
            TecnicoModel t = new TecnicoModel();
            TecnicosView tecnicosView = new TecnicosView();
            JpaTecnicoRepository repository = new JpaTecnicoRepository();
            TecnicosController tC = new TecnicosController(t, tecnicosView);
            tC.repository = repository;

            Scanner scn = new Scanner(System.in);

            System.out.println("Nombre:");
            String txt = scn.nextLine();


            System.out.println("Ingrese horas extras estimadas:");
            long cuil = scn.nextLong();

            scn.nextLine();

            System.out.println("Ingrese especialidad: ");
            String nottxt = scn.nextLine().toUpperCase();
            if (!Consultas.existeEspecialidad(nottxt)){
                registrarNuevaEspecialidad();
            }

            tC.model.setColchonHoras((int)cuil);
            tC.setNombreTecnico(txt);
            tC.agregarEspecialidad(nottxt);


            tC.repository.actualizarTecnico(tC.model);

        } catch (Exception e) {
            System.out.println("Error al crear nuevo registro Tecnico: \n" + e);
        }
    }
    public static void registrarIncidente() {
        em = Persistence.createEntityManagerFactory("JPA_PU").createEntityManager();
        try {
            IncidenteModel i = new IncidenteModel(LocalDateTime.now(), 1, 0, State.INICIADO, new ArrayList<OperadorModel>(), new ClienteModel(), new ArrayList<TecnicoModel>(), new ArrayList<TipoProblemaModel>());
            IncidentesView incidentesView = new IncidentesView();
            JpaIncidenteRepository repository = new JpaIncidenteRepository();
            IncidentesController control = new IncidentesController(i, incidentesView);
            ClienteModel cM = new ClienteModel();
            JpaClienteRepository clienteRepository = new JpaClienteRepository();

            JpaTecnicoRepository tecnicoRepository = new JpaTecnicoRepository();

            Scanner teclado = new Scanner(System.in);

            String[] opcionesCliente = devolverArrayDeStrings(cM.listarClientesPorId());
        String ans = (String)  JOptionPane.showInputDialog(null,
                    "Text",
        "Seleccion de Cliente",
        JOptionPane.INFORMATION_MESSAGE,
                    null,
                        opcionesCliente,
                    0);

          //ClienteModel cM = clienteRepository.obtenerClientePorId(ans);


            teclado.nextLine();
            String salir;
            String tp;

            do {
                tp = JOptionPane.showInputDialog("Ingrese problemas involucrados en el incidente: ");
                //Verificar si existe un problema
                if (Consultas.existeTipoDeProblema(tp)) {
                    i.agregarProblemas(i.obtenerTipoDeProblemaPorNombre(tp));
                } else {
                    String agregar = JOptionPane.showInputDialog("Problema no registrado con anterioridad, \ndesea agregarlo al registro?");

                    if (agregar.equalsIgnoreCase("S")) {
                        Crear.registrarNuevoTipoDeProblema();
                        System.out.println("Problema agregado al registro:  \n" + tp);
                    } else {
                        System.out.println("Problema no agregado al registro");
                    }
                }

                System.out.println(Consultas.existeTipoDeProblema(tp));
                System.out.println ("Agregar problema? (S/N):");
                salir = teclado.nextLine();
                boolean n = salir.equalsIgnoreCase("n");
                System.out.println(salir + " " +  n);
            } while(!salir.equalsIgnoreCase("n"));

            salir = "s";
            do {

                //esto se puede mover a la clase IncidenteModel (necesito tenerlo acá por claridad)
                String[] opciones = devolverArrayDeStrings(i.listarProblemas());
                mostrarOpcionesConId(opciones, i.listarProblemas());
                System.out.println ("Seleccione id de problema:");

                System.out.println ("Ingrese tecnicos involucrados en incidente:");

                tp = teclado.nextLine();
                //Verificar si existe un problema
                if (!Consultas.existeTipoDeProblema(tp)) {
                    System.out.println("Problema no existente con anterioridad, agregar al registro?(S/N) ");
                    String agregar = teclado.nextLine();
                    if (agregar.equalsIgnoreCase("S")) {
                        Crear.registrarNuevoTipoDeProblema();
                        System.out.println("Problema agregado al registro:  \n" + tp);
                    } else {
                        System.out.println("Problema no agregado al registro");
                    }
                }
                System.out.println(Consultas.existeTipoDeProblema(tp));
                System.out.println ("Agregar problema? (S/N):");
                salir = teclado.nextLine();
                boolean n = salir.equalsIgnoreCase("n");
                System.out.println(salir + " " +  n);
            } while(!salir.equalsIgnoreCase("n"));


            new TecnicoModel();
            TecnicoModel tecnicoModel;
            tecnicoModel = tecnicoRepository.obtenerTecnicoPorId(1);

           /* if (!em.contains(cM)){
                cM = em.merge(cM);

            */
            String userinput = JOptionPane.showInputDialog("Ingrese problemas involucrados en incidente: ");

          /*  System.out.println ("Ingrese problemas involucrados en incidente:");
            */
            System.out.println(Consultas.existeTipoDeProblema(userinput));

            if (!Consultas.existeTipoDeProblema(userinput)) {
                System.out.println("Problema no existente con anterioridad, por favor registrar: ");
                Crear.registrarNuevoTipoDeProblema();
            }
            i.setCliente(cM);
            control.setTecnicos(tecnicoModel);
            control.setEstadoIncidenteActual(State.INICIADO);
            repository.actualizarIncidente(control.model);
        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }


    }


    public static void registrarNuevoTipoDeProblema() {

        try{
            TipoProblemaModel p = new TipoProblemaModel(/*new ArrayList<>(), new ServicioModel()*/);
            TipoProblemaView tipoProblemaView = new TipoProblemaView();
            TipoProblemaController tipoProblemaController = new TipoProblemaController(p, tipoProblemaView);

            JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();

            TipoProblemaController control = new TipoProblemaController(p, tipoProblemaView);


            String desc = JOptionPane.showInputDialog("Ingrese tipo de problema");

            //control.setIncidentes(listaDeIncidentes);
            control.setNombreTipoProblema(desc);
            repository.guardarTipoProblema(control.model);

        } catch (Exception e) {
            System.out.println("Problema grave: " + e);
        }

    }

    public void registrarNuevaEspecialidad() {

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

            control.repository.guardarEspecialidad(i);

        } catch (Exception e) {
            System.out.println("Problema:" + e);
        }
    }
    public static void mostrarOpcionesConId(String[] opcion, List<Par<Integer, String>> lista) {
        String[] opciones  = opcion;
        Arrays.stream(opciones).toList().stream().forEach(caso -> System.out.println(caso));

        int choice = JOptionPane.showOptionDialog(
                null,
                "Select an option:",
                "Menu Inicial",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        // Check the user's choice
        JOptionPane.showMessageDialog(null, "La opción seleccionada no es válida");
    }
}

