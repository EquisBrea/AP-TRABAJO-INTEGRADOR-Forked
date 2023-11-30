package org.cursoutn;

import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.repository.JpaIncidenteRepository;

import java.util.stream.Collectors;

public class Listar {
    public static void listarClientes() throws Exception {
        JpaClienteRepository repo = new JpaClienteRepository();
         repo.obtenerTodosLosClientes().forEach(clienteModel -> {
            System.out.println("Id cliente: " + clienteModel.getId() + " " + clienteModel.getRazon_social());
        });

    }
    public static void listarIncidentes() throws Exception {
        JpaIncidenteRepository r1 = new JpaIncidenteRepository();
        r1.obtenerTodosLosIncidentes().stream().
                forEachOrdered(tecnico -> System.out.println(tecnico.getTipoProblema() + " "));
    }
}
