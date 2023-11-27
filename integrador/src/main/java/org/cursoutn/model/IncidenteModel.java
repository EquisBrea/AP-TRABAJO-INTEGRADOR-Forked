package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.state.EstadoEnCurso;
import org.cursoutn.state.EstadoFinalizado;
import org.cursoutn.state.EstadoIncidente;
import org.cursoutn.state.EstadoIniciado;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="incidente")
public class IncidenteModel implements Serializable {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private LocalDateTime fechaHoraIncidente;
    @Column
    private int tiempoNecesario;
    @Column
    private int esComplejo;
    @Column
    private EstadoIncidente estadoIncidenteActual;
    @ManyToMany
    @JoinColumn(name="operador_id",referencedColumnName = "id")
    private List<OperadorModel> operadores;
    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private ClienteModel cliente;
    @ManyToMany(mappedBy = "incidente")
    private List<TecnicoModel> tecnicos;
    @OneToMany
    @MapsId
    @JoinColumn(name="tipo_problema_id",referencedColumnName = "id")
    private List<TipoProblemaModel> tipoProblema;
    public IncidenteModel() {
    }

    public IncidenteModel(int id, LocalDateTime fechaHoraIncidente, int tiempoNecesario, int esComplejo, EstadoIncidente estadoIncidenteActual, List<TipoProblemaModel> tipoProblema, List<TecnicoModel> tecnicos) {
        this.id = id;
        this.fechaHoraIncidente = fechaHoraIncidente;
        this.tiempoNecesario = tiempoNecesario;
        this.esComplejo = esComplejo;
        this.estadoIncidenteActual = estadoIncidenteActual;
        this.tipoProblema = tipoProblema;
        this.tecnicos = tecnicos;
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

    public EstadoIncidente getEstadoIncidenteActual() {
        return estadoIncidenteActual;
    }

    public void setEstadoIncidenteActual(EstadoIncidente estadoIncidenteActual) {
        this.estadoIncidenteActual = estadoIncidenteActual;
    }

    public void setOperadores(List<OperadorModel> operadores) {
        this.operadores = operadores;
    }

    public List<OperadorModel> getOperadores() {
        return operadores;
    }

    public ClienteModel getCliente() {
        return cliente;
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

    public void iniciar() {
        estadoIncidenteActual = new EstadoIniciado();
        estadoIncidenteActual.iniciar(this);
    }

    public void enCurso() {
        estadoIncidenteActual = new EstadoEnCurso();
        estadoIncidenteActual.enCurso(this);
    }

    public void finalizar() {
        estadoIncidenteActual = new EstadoFinalizado();
        estadoIncidenteActual.finalizar(this);
    }
}
