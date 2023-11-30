package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.repository.JpaEspecialidadRepository;
import org.cursoutn.repository.JpaIncidenteRepository;
import org.cursoutn.repository.JpaTecnicoRepository;

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
    public static void listarTecnicos() throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository r1 = new JpaTecnicoRepository();
        JpaEspecialidadRepository r2 = new JpaEspecialidadRepository();

        r1.obtenerTodosLosTecnicos().stream().
                forEachOrdered(tecnico -> System.out.println(tecnico.getId() + tecnico.getNombreTecnico()));
    }
}
