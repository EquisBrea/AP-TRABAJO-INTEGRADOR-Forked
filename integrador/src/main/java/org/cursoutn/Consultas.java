package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.model.EspecialidadModel;
import org.cursoutn.repository.JpaEspecialidadRepository;
import org.cursoutn.repository.JpaTecnicoRepository;
import org.cursoutn.repository.JpaTipoProblemaRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Consultas {

    public static void listarClientes() {

    }

    public static void listarIncidentes() {

    }

    public static void listarTecnicos() throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository repository = new JpaTecnicoRepository();
        System.out.println(repository.obtenerTodosLosTecnicos().stream().toString());
    }

    public static void consultarDesempenioTecnicos() throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository repository = new JpaTecnicoRepository();
            Scanner scn = new Scanner(System.in);
            System.out.println("Introduzca fecha(ddmmaaaa):");
            LocalDate date = LocalDate.parse(scn.nextLine(), DateTimeFormatter.ofLocalizedDate(FormatStyle.valueOf("ddmmaaaa")));
    }
    public static boolean existeTipoDeProblema(String tipoDescripcion) throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();
        return repository.obtenerTodosLosTipoProblema().stream().
                anyMatch(problema -> Objects.equals(problema.getNombreTipoProblema(), tipoDescripcion));
    }

    public static boolean existeEspecialidad(String tipoDescripcion) throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaEspecialidadRepository repository = new JpaEspecialidadRepository();
        return repository.obtenerTodasLasEspecialidades().stream().
                anyMatch(problema -> Objects.equals(problema.getNombreEspecialidad(), tipoDescripcion));

    }

    public static boolean existeTecnicoParaEspecialidad(EspecialidadModel especialidad) throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository repository = new JpaTecnicoRepository();
        return repository.obtenerTodosLosTecnicos().stream().
                anyMatch(problema -> Objects.equals(problema.getEspecialidades(), especialidad));
    }
}
