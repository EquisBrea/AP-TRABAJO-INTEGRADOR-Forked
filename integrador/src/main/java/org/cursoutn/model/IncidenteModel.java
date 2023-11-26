package org.cursoutn.model;

import jakarta.persistence.*;
import org.cursoutn.state.EstadoEnCurso;
import org.cursoutn.state.EstadoFinalizado;
import org.cursoutn.state.EstadoIncidente;
import org.cursoutn.state.EstadoIniciado;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="incidentes")
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
    @Transient
    private EstadoIncidente estadoIncidenteActual;
    @OneToMany
    @MapsId
    @JoinColumn(name="tipo_problema",referencedColumnName = "id")
    private List<TipoProblemaModel> tipoProblema;
    @OneToMany
    @MapsId
    @JoinColumn(name = "tecnico", referencedColumnName = "id")
    private List<TecnicoModel> tecnicos;

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
