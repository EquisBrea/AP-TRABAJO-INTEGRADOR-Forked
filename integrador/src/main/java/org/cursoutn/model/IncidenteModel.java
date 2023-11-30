package org.cursoutn.model;

import com.mysql.cj.conf.ConnectionUrlParser;
import jakarta.persistence.*;
import org.cursoutn.Par;
import org.cursoutn.repository.JpaIncidenteRepository;
import org.cursoutn.repository.JpaTipoProblemaRepository;
import org.cursoutn.state.*;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @ManyToOne
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
}
