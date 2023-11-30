package org.cursoutn;

import org.cursoutn.controller.ClientesController;
import org.cursoutn.controller.TecnicosController;
import org.cursoutn.model.TecnicoModel;
import org.cursoutn.repository.JpaTecnicoRepository;

import java.util.Scanner;

import static java.lang.Long.parseLong;

public class Menu {
    public static void menuIngresarDatos() throws Exception {
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
    }

    private static void registrarNuevoCliente() throws Exception {

    }
    /*


 */
    public static void menuInicial() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la opción deseada");
        System.out.println ("1- Ingresar datos");
        System.out.println ("2- Buscar datos");
        System.out.println ("3- Eliminar datos");
        System.out.println ("4- Consultas");
        System.out.println ("5- Salir");
        int seleccion = teclado.nextInt();
        switch(seleccion) {
            case 1:
                menuIngresarDatos();
                break;
            case 2:
                menuBuscarDatos();
                break;
            case 3:
                menuEliminarDatos();
                break;
            case 4:
                menuConsultas();
                break;
            case 5:
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
        }
    }

    private static void menuEliminarDatos() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción deseada:");
        System.out.println("1- Borrar incidente");
        System.out.println("2- Borrar cliente:");
        System.out.println("3- Borrar técnico:");
        System.out.println("4- Borrar especialidad:");
        int seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                Crear.menuRegistrarIncidente();
                break;
            case 2:
                Eliminar.borrarCliente();
                menuInicial();
                break;
            case 3:
                Eliminar.borrarTecnico();
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
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la opción deseada:");
        System.out.println ("1- Listar clientes:");
        System.out.println ("2- Listar incidentes:");
        System.out.println ("3- Listar tecnicos:");
        System.out.println ("4- Desempenio Tecnicos:");

        int seleccion = teclado.nextInt();
        switch(seleccion) {
            case 1:
                menuBuscarIncidentePorId();
                break;
            case 2:
                menuListarIncidentesPor();
                Consultas.listarIncidentesPor();
                break;
            case 3:
                Consultas.listarTecnicos();
                break;
            case 4:
                Consultas.consultarDesempenioTecnicos();
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
        }
    }

    private static void menuListarIncidentesPor() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la opción deseada:");
        System.out.println ("1- ...cliente:");
        System.out.println ("2- ...problema:");
        System.out.println ("3- ...tecnico:");
        System.out.println ("3- Salir:");
        int seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                break;
                case 2:
                    break;
            case 3:
                Scanner tecl = new Scanner(System.in);
                System.out.println("Ingrese ID de Tecnico");
                int busq =  tecl.nextInt();
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
        System.out.println ("Por favor ingrese la opción deseada:");
        System.out.println ("1- Buscar Incidente por ID");
        System.out.println ("2- Buscar Cliente por ID");
        System.out.println ("3- Buscar Tecnico por ID");
        System.out.println ("4- Buscar Especialidad por ID");
        System.out.println ("5- Consultas e informes");
        int seleccion = teclado.nextInt();
        int id;
        switch(seleccion) {
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
        System.out.println ("Por favor ingrese el id del cliente:");
        int clienteId = teclado.nextInt();}



}