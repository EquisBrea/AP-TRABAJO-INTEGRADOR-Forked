package org.cursoutn;

import org.cursoutn.controller.ClientesController;
import org.cursoutn.controller.TecnicosController;
import org.cursoutn.model.TecnicoModel;
import org.cursoutn.repository.JpaTecnicoRepository;

import javax.swing.*;
import java.util.*;

import static java.lang.Long.parseLong;

public class Menu {
    public static void menuIngresarDatos() throws Exception {
        String[] opciones = {"1- Ingresar nuevo incidente", "2- Ingresar nuevo cliente", "3- Ingresar nuevo tecnico", "4- Ingresar nuevo Especialidad", "6- Salir"};

        int choice = JOptionPane.showOptionDialog(
                null,
                "Select an option:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]
        );
        Crear crear = new Crear();
        // Verificar la eleccion del usuario
        switch (choice) {
            case 0:
                Crear.menuRegistrarIncidente();
                break;
            case 1:
                Crear.registrarNuevoCliente();
                break;
            case 2:
                Crear.registrarNuevoTecnico();
                break;
            case 3:
                Crear.registrarNuevaEspecialidad();
            case 4:
                showMenu();
                break;
            case 5:
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opción seleccionada no es válida");
        }/*
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción deseada:");
        System.out.println("1- Ingresar nuevo incidente");
        System.out.println("2- Registrar nuevo cliente:");
        System.out.println("3- Registrar nuevo técnico:");
        System.out.println("4- Registrar especialidad:");
        System.out.println("5- Volver al menu inicial:");
        int seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                Crear.menuRegistrarIncidente();
                menuInicial();
                break;
            case 2:
                Crear.registrarNuevoCliente();
                menuInicial();
                break;
            case 3:
                Crear.registrarNuevoTecnico();
                menuIngresarDatos();
                break;
            case 4:
                Crear.registrarNuevaEspecialidad();
                menuIngresarDatos();
            default:
                System.out.println("La opción seleccionada no es válida");
                menuInicial();
        }
        */
    }

    private static void registrarNuevoCliente() throws Exception {

    }

    /*


     */
    public static void menuInicial() {
        // Scanner teclado = new Scanner(System.in);
        //System.out.println("Por favor ingrese la opción deseada");
        //int seleccion = teclado.nextInt();

    }

    public static void showMenu() throws Exception {
        String[] opciones = {"1- Ingresar datos", "2- Buscar datos", "3- Eliminar datos", "4- Actualizar datos", "5- Consultas", "6- Salir"};

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
        switch (choice) {
            case 0:
                menuIngresarDatos();
                break;
            case 1:
                menuBuscarDatos();
                break;
            case 2:
                menuEliminarDatos();
                break;
            case 3:
                menuActualizarDatos();
            case 4:
                menuConsultas();
                break;
            case 5:
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opción seleccionada no es válida");
        }
    }

    private static void menuActualizarDatos() {
    }

    private static void menuEliminarDatos() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción deseada:");
        System.out.println("1- Borrar incidente");
        System.out.println("2- Borrar cliente:");
        System.out.println("3- Borrar técnico:");
        System.out.println("4- Borrar especialidad:");
        Crear crear = new Crear();
        int seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                crear.menuRegistrarIncidente();
                break;
            case 2:
                Eliminar.borrarCliente();
                menuEliminarDatos();
                break;
            case 3:
                Eliminar.borrarTecnico();
                menuEliminarDatos();
                break;
            case 4:
                Eliminar.borrarEspecialidad();
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
        }
    }

    private static void borrarCliente(ClientesController cliente) throws Exception {
        cliente.eliminarCliente(cliente.model);
    }

    private static void menuConsultas() throws Exception {
        String[] opciones = {"1- Listar clientes", "2- Buscar incidentes", "3- Eliminar tecnicos", "4- Desempeño tecnicos", "5- Salir"};

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
        switch (choice) {
            case 0:
                Listar.listarClientes();
                menuConsultas();
                break;
            case 1:
                Listar.listarIncidentes();
                menuConsultas();
                break;
            case 2:
                Listar.listarTecnicos();
                menuConsultas();
                break;
            case 3:
                TecnicoModel tecnicazo = new TecnicoModel();
                Consultas.tecnicoConMayorCantidadDeIncidentesResueltos();
                JOptionPane.showMessageDialog(null, tecnicazo.getNombreTecnico());
                menuConsultas();
            case 4:
                showMenu();
                break;
            default:
                JOptionPane.showMessageDialog(null, "La opción seleccionada no es válida");
        }
        /*Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la opción deseada:");
        System.out.println ("1- Listar clientes:");
        System.out.println ("2- Listar incidentes:");
        System.out.println ("3- Listar tecnicos:");
        System.out.println ("4- Desempenio Tecnicos:");
        System.out.println ("5- Salir");

        int seleccion = teclado.nextInt();
        switch(seleccion) {
            case 1:
                Listar.listarClientes();
                menuConsultas();
                break;
            case 2:
                menuListarIncidentesPor();
                Consultas.listarIncidentesPor();
                menuConsultas();
                break;
            case 3:
                Listar.listarTecnicos();
                menuConsultas();
                break;
            case 4:
                Consultas.tecnicoConMayorCantidadDeIncidentesResueltos();
                menuConsultas();
                break;
            case 5:
                menuInicial();
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
        }*/
    }

    private static void menuListarIncidentesPor() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción deseada:");
        System.out.println("1- ...cliente:");
        System.out.println("2- ...problema:");
        System.out.println("3- ...tecnico:");
        System.out.println("3- Salir:");
        int seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                Scanner tecl = new Scanner(System.in);
                System.out.println("Ingrese ID de Tecnico");
                int busq = tecl.nextInt();
                JpaTecnicoRepository repo1 = new JpaTecnicoRepository();
                TecnicoModel tecni = repo1.obtenerTecnicoPorId(busq);
                Consultas.listarIncidentesPorTecnico(tecni);
                break;
            case 4:
                menuConsultas();
                break;
            default:
                System.out.println("Opcion no disponible.");
                menuListarIncidentesPor();
        }
    }


    public static int menuBuscarDatos() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción deseada:");
        System.out.println("1- Buscar Incidente por ID");
        System.out.println("2- Buscar Cliente por ID");
        System.out.println("3- Buscar Tecnico por ID");
        System.out.println("4- Buscar Especialidad por ID");
        System.out.println("5- Consultas e informes");
        int seleccion = teclado.nextInt();
        int id;
        switch (seleccion) {
            case 1:
                System.out.println("Introduzca ID");
                id = teclado.nextInt();
                return id;
            case 2:
                System.out.println("Introduzca ID");
                id = teclado.nextInt();
                return id;
            case 3:
                System.out.println("Introduzca ID");
                id = teclado.nextInt();
                return id;
            case 4:
                System.out.println("Introduzca ID");
                id = teclado.nextInt();
                return id;

            default:
                System.out.println("La opción seleccionada no es válida");
        }
        return 0;
    }

    private static void menuBuscarIncidentePorId() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese el id del cliente:");
        int clienteId = teclado.nextInt();
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



