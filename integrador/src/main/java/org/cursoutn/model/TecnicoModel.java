package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="tecnico")
public class TecnicoModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreTecnico;

    private int colchonHoras;

    @ManyToMany(mappedBy = "tecnicos")
    private List<IncidenteModel> incidentes;

    @ManyToMany(mappedBy = "tecnicos")
    @Column(nullable = false)
    private List<EspecialidadModel> especialidades;

    public TecnicoModel() {
    }

    public TecnicoModel(String nombreTecnico, List<EspecialidadModel> especialidades) {
        this.nombreTecnico = nombreTecnico;
        this.especialidades = especialidades;
    }

    public TecnicoModel(String nombreTecnico, int colchonHoras, List<IncidenteModel> incidentes,
                        List<EspecialidadModel> especialidades) {
        this.nombreTecnico = nombreTecnico;
        this.colchonHoras = colchonHoras;
        this.incidentes = incidentes;
        this.especialidades = especialidades;
    }
}
