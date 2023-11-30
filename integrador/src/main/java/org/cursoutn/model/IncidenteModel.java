package org.cursoutn.model;

import jakarta.persistence.*;
import org.cursoutn.state.*;
import org.hibernate.annotations.DynamicInsert;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
    @JoinColumn(name="cliente_id", referencedColumnName = "id", nullable = false)
    private ClienteModel cliente;

    @ManyToMany
    private List<TecnicoModel> tecnicos;

    @ManyToMany(mappedBy = "incidentes")
    private List<TipoProblemaModel> tipoProblema;

    public IncidenteModel() {
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




}
