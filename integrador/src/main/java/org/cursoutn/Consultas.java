package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.model.TecnicoModel;
import org.cursoutn.repository.JpaEspecialidadRepository;
import org.cursoutn.repository.JpaIncidenteRepository;
import org.cursoutn.repository.JpaTecnicoRepository;
import org.cursoutn.repository.JpaTipoProblemaRepository;
import org.cursoutn.state.State;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Consultas {

    public static void listarClientes() {

    }



    public static void listarTecnicos() throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository r1 = new JpaTecnicoRepository();
        JpaEspecialidadRepository r2 = new JpaEspecialidadRepository();

        r1.obtenerTodosLosTecnicos().stream().
                forEachOrdered(tecnico -> System.out.println(tecnico.getNombreTecnico() + " "));
        r2.obtenerTodasLasEspecialidades().stream().
                forEachOrdered(espec -> System.out.println(espec.getNombreEspecialidad()));
    }

    public static void consultarDesempenioTecnicos() throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        JpaTecnicoRepository repository = new JpaTecnicoRepository();
            Scanner scn = new Scanner(System.in);
            System.out.println("Introduzca fecha(ddmmaaaa):");
            LocalDate date = LocalDate.parse(scn.nextLine(), DateTimeFormatter.ofLocalizedDate(FormatStyle.valueOf("ddmmaaaa")));
    }
    public static boolean existeTipoDeProblema(String tipoDescripcion) throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();
        return repository.obtenerTodosLosTipoProblema().stream().
                anyMatch(problema -> Objects.equals(problema.getNombreTipoProblema(), tipoDescripcion));
    }

    public static boolean existeEspecialidad(String tipoDescripcion) throws Exception {
        JpaEspecialidadRepository repository = new JpaEspecialidadRepository();
        return repository.obtenerTodasLasEspecialidades().stream().
                anyMatch(problema -> problema.getNombreEspecialidad().equalsIgnoreCase(tipoDescripcion));
    }

    public static boolean existeTecnico(int especialidad) throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository repository = new JpaTecnicoRepository();
        return repository.obtenerTodosLosTecnicos().stream().
                anyMatch(problema -> Objects.equals(problema.getEspecialidades(), especialidad));
    }

    public static void listarIncidentesPor() {

    }

    public static void listarIncidentesPorTecnico(TecnicoModel tecnico) throws Exception {
        JpaIncidenteRepository r1 = new JpaIncidenteRepository();
        r1.obtenerTodosLosIncidentes().stream().filter(filtro -> filtro.getTecnicos().stream().anyMatch(filtro1 -> filtro1 == tecnico) );
    }
    public static TecnicoModel tecnicoConMayorCantidadDeIncidentesResueltos() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese fecha (ddmmaaaa: ");
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("ddmmyyyy");
        LocalDate fecha = LocalDate.parse(scn.nextLine(),formatoFecha);
        ChronoLocalDateTime fechaExacta = fecha.atStartOfDay();

        JpaTecnicoRepository repository = new JpaTecnicoRepository();
        return repository.obtenerTodosLosTecnicos().stream()
                .filter(tecnico -> tecnico.getIncidentes().stream()
                        .allMatch(incidente -> incidente.getFechaHoraIncidente().isAfter(fechaExacta)))
                .max(Comparator.comparingInt(caso -> Math.toIntExact(caso.getIncidentes().stream()
                        .filter(incidente -> incidente.getEstadoIncidente().equals(State.RESUELTO)).count())))
                .orElse(null);
    }

}
