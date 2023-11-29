package org.cursoutn.model;

import jakarta.persistence.*;
import org.cursoutn.state.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="incidente")
public class IncidenteModel implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime fechaHoraIncidente;

    @Column
    private int tiempoNecesario;

    @Column
    private int esComplejo;

    @Column
    private IncidenteState estadoIncidente;

    @ManyToMany(mappedBy = "incidentes")
    private List<OperadorModel> operadores;

    @ManyToOne
    @JoinColumn(name="cliente_id", referencedColumnName = "id", nullable = false)
    private ClienteModel cliente;

    @ManyToMany(mappedBy = "incidentes")
    private List<TecnicoModel> tecnicos;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "incidente_tipo_problema",
            joinColumns = @JoinColumn(name = "incidente_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_problema_id", referencedColumnName = "id")
    )
    private List<TipoProblemaModel> tipoProblema;

    public IncidenteModel() {
    }

    public IncidenteModel(int id, LocalDateTime fechaHoraIncidente, int tiempoNecesario, int esComplejo, IncidenteState estadoIncidente, List<TipoProblemaModel> tipoProblema, List<TecnicoModel> tecnicos) {
        this.id = id;
        this.fechaHoraIncidente = fechaHoraIncidente;
        this.tiempoNecesario = tiempoNecesario;
        this.esComplejo = esComplejo;
        this.estadoIncidente = estadoIncidente;
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

    public IncidenteState getEstadoIncidente() {
        return this.estadoIncidente;
    }

    public void setEstadoIncidente(IncidenteState estadoIncidente) {
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
