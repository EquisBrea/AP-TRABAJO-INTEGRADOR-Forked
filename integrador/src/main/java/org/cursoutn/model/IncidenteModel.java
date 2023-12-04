package org.cursoutn.model;

import com.mysql.cj.conf.ConnectionUrlParser;
import jakarta.persistence.*;
import org.cursoutn.Consultas;
import org.cursoutn.Crear;
import org.cursoutn.Par;
import org.cursoutn.controller.IncidentesController;
import org.cursoutn.repository.JpaClienteRepository;
import org.cursoutn.repository.JpaIncidenteRepository;
import org.cursoutn.repository.JpaTecnicoRepository;
import org.cursoutn.repository.JpaTipoProblemaRepository;
import org.cursoutn.state.*;
import org.cursoutn.view.IncidentesView;
import org.hibernate.annotations.DynamicInsert;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static org.cursoutn.Consultas.devolverArrayDeStrings;
import static org.cursoutn.Crear.mostrarOpcionesConId;

@Entity
@Table(name="incidente")
public class IncidenteModel implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime fechaHoraIncidente;

    @Column
    private Integer tiempoNecesario;

    @Column
    private Integer esComplejo;

    @Column
    private State estadoIncidente;

    @ManyToMany
    private List<OperadorModel> operadores;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="cliente_id", referencedColumnName = "id")
    private ClienteModel cliente;

    @ManyToMany
    private List<TecnicoModel> tecnicos;

    @ManyToMany(mappedBy = "incidentes")
    private List<TipoProblemaModel> tipoProblema;

    public IncidenteModel() {
        this.fechaHoraIncidente = LocalDateTime.now();
        this.tiempoNecesario = 1;
        this.esComplejo = 0;
        this.estadoIncidente = State.INICIADO;
        this.operadores = new ArrayList<>();
        this.cliente = new ClienteModel();
        this.tecnicos = new ArrayList<>();
        this.tipoProblema = new ArrayList<>();
    }

    public IncidenteModel(LocalDateTime fechaHoraIncidente, int tiempoNecesario, int esComplejo, State estadoIncidente,
                          List<TipoProblemaModel> tipoProblema, List<TecnicoModel> tecnicos) {
        this.fechaHoraIncidente = fechaHoraIncidente;
        this.tiempoNecesario = tiempoNecesario;
        this.esComplejo = esComplejo;
        this.estadoIncidente = estadoIncidente;
        this.tipoProblema = tipoProblema;
    }

    public IncidenteModel(LocalDateTime fechaHoraIncidente, int tiempoNecesario, int esComplejo, State estadoIncidente,
                          List<OperadorModel> operadores, ClienteModel cliente, List<TecnicoModel> tecnicos,
                          List<TipoProblemaModel> tipoProblema) {
        this.fechaHoraIncidente = fechaHoraIncidente;
        this.tiempoNecesario = tiempoNecesario;
        this.esComplejo = esComplejo;
        this.estadoIncidente = estadoIncidente;
        this.operadores = operadores;
        this.cliente = cliente;
        this.tecnicos = tecnicos;
        this.tipoProblema = tipoProblema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraIncidente() {
        return fechaHoraIncidente;
    }

    public void setFechaHoraIncidente(LocalDateTime fechaHoraIncidente) {
        this.fechaHoraIncidente = fechaHoraIncidente;
    }

    public int getTiempoNecesario() {
        return tiempoNecesario;
    }

    public void setTiempoNecesario(int tiempoNecesario) {
        this.tiempoNecesario = tiempoNecesario;
    }

    public int getEsComplejo() {
        return esComplejo;
    }

    public void setEsComplejo(int esComplejo) {
        this.esComplejo = esComplejo;
    }

    public State getEstadoIncidente() {
        return this.estadoIncidente;
    }

    public void setEstadoIncidente(State estadoIncidente) {
        this.estadoIncidente = estadoIncidente;
    }

    public void setOperadores(List<OperadorModel> operadores) {
        this.operadores = operadores;
    }

    public List<OperadorModel> getOperadores() {
        return this.operadores;
    }

    public ClienteModel getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public List<TipoProblemaModel> getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(List<TipoProblemaModel> tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public List<TecnicoModel> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<TecnicoModel> tecnicos) {
        this.tecnicos = tecnicos;
    }
    public List<Par<Integer, String>> listarProblemas () {
        List<Par<Integer, String>> pares = new ArrayList<>();
        this.getTipoProblema().forEach(problemas ->
        {
            int id = problemas.getId();
            String nombreProblema = problemas.getNombreTipoProblema();
            pares.add(new Par<>(id, nombreProblema));
        });

        return pares;
    }


    public void agregarProblemas(TipoProblemaModel problemaNuevo) {
        this.getTipoProblema().add(problemaNuevo);
    }
    public TipoProblemaModel obtenerTipoDeProblemaPorNombre(String tp) throws Exception {
        JpaTipoProblemaRepository repository = new JpaTipoProblemaRepository();
        return repository.obtenerTodosLosTipoProblema().stream().
                filter(problema -> problema.getNombreTipoProblema().equalsIgnoreCase(tp)).
                findAny().orElseThrow(() -> new Exception());

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
                        Crear.registrarNuevoTipoDeProblema(tp);
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
                        Crear.registrarNuevoTipoDeProblema(tp);
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
}
