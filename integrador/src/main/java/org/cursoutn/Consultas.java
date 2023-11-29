package org.cursoutn;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.cursoutn.model.TipoProblemaModel;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.repository.JpaTecnicoRepository;
import org.cursoutn.repository.JpaTipoProblemaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

public class Consultas {

    public static void listarClientes() {

    }

    public static void listarIncidentes() {

    }

    public static void listarTecnicos() {

    }

    public static void consultarDesempenioTecnicos() {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTecnicoRepository repository = new JpaTecnicoRepository();

        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Introduzca fecha(ddmmaaaa):");
            repository.obtenerTodosLosTecnicos();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean existeTipoDeProblema(String tipoDescripcion) throws Exception {
        EntityManager em = Main.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();
        return repository.obtenerTodosLosTipoProblema().stream().
                anyMatch(problema -> Objects.equals(problema.getNombreTipoProblema(), tipoDescripcion));
    }
}
