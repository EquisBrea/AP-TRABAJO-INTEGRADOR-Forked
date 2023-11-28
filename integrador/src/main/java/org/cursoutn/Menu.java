package org.cursoutn;

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
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese la razón social del cliente:");
        String nombre = teclado.nextLine ();
        System.out.println ("Por favor ingrese el cuit del cliente:");
        Long cuit = Long parseLong(teclado.nextLine ());
        System.out.println ("Por favor ingrese el domicilio del cliente:");
        String domicilio = teclado.nextLine ();
        System.out.println ("Por favor ingrese el telefono del cliente:");
        Long teleTonO = parseLong teclado.nextLineO);
        System.out.printIn ("Por favor ingrese el maill del cliente:");
        string mail = teclado. nexto;
        int opcionServicio;
        ServicioContratado contratacion = ServicioContratado. PACK_BASICO;
        do {
            System.out.println ("Por favor ingrese el servicio contratado por el cliente:");
            System.out.printIn ("1 - Pack básico");
            System.out.printin ("2
                            - Pack intermedio");
                    System.out.printin ("3 - Pack full");
            opcionServicio = teclado.nextInt ();
            T
            switch (opcionServicio) {
                case 1:
                    contratacion = ServicioContratado.PACK_ BASICO;
                    break;
                case 2:
                    contratacion = ServicioContratado. PACK_INTERMEDIO;
                    break;
                case 3:
                    contratacion = ServicioContratado.PACK_FULL;
                    break;
                default:
                    System.out.println ("La opción ingresada no es valida por favor ingrese una opción valida.");
    }

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
        System.out.println ("1- Buscar Incidente por ID");
        System.out.println ("2- Buscar Cliente por ID");
        System.out.println ("3- Buscar Tecnico por ID");
        System.out.println ("4- Buscar Especialidad por ID");
        System.out.println ("5- Consultas e informes");
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
        int clienteId = teclado.nextInt();
        MainController.buscarClientePorId(clienteId);
    }

    public static void menuRegistrarIncidente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println ("Por favor ingrese el id del cliente:");
        int clienteId = teclado.nextInt();
    }

}