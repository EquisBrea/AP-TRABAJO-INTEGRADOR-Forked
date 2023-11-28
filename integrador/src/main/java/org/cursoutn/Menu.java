package org.cursoutn;

import jakarta.persistence.PersistenceUnit;
import org.cursoutn.controller.ClientesController;

import java.util.Scanner;

import static java.lang.Long.parseLong;

public class Menu {
    public static void menuIngresarDatos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese la opción deseada:");
        System.out.println("1- Ingresar nuevo incidente");
        System.out.println("2- Registrar nuevo cliente:");
        System.out.println("3- Registrar nuevo técnico:");
        System.out.println("4- Registrar especialidad:");
        int seleccion = teclado.nextInt();
        switch (seleccion) {
            case 1:
                menuRegistrarIncidente();
                break;
            case 2:
               // ClientesController nuevo = Main.abrirCliente();
               // Main.registrarNuevoCliente(nuevo);
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
        }
    }
/*


 */
    public static void menuInicial() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la opción deseada");
        System.out.println ("1- Ingresar datos");
        System.out.println ("2- Buscar datos");
        System.out.println ("3- Consultas");
        System.out.println ("4- Salir");
        int seleccion = teclado.nextInt();
        switch(seleccion) {
            case 1:
                menuIngresarDatos();
                break;
            case 2:
                menuBuscarDatos();
                break;
            case 3:
                menuConsultas();
                break;
            case 4:
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
        }
    }

    private static void menuConsultas() throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la opción deseada:");
        System.out.println ("1- Tecnico con más incidentes resueltos:");
        int seleccion = teclado.nextInt();
        switch(seleccion) {
            case 1:
                menuBuscarIncidentePorId();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("La opción seleccionada no es válida");
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

    public static void menuRegistrarIncidente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese el id del cliente:");
        int clienteId = teclado.nextInt();
    }

}