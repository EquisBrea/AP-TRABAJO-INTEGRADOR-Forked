package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.state.State;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;
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

    @Column(columnDefinition = "varchar(255) default 'Facundo Vargas'")
    private String nombreTecnico;

    private int colchonHoras;

    @ManyToMany(mappedBy = "tecnicos")
    private List<IncidenteModel> incidentes;

    @ManyToMany
    @Column()
    @JoinTable(
            name = "especialidad_tenico",
            joinColumns = @JoinColumn(name = "tecnico_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id", referencedColumnName = "id")
    )
    private List<EspecialidadModel> especialidades;

    public TecnicoModel() {
    }
    public TecnicoModel(String nombreTecnico) {
        this.nombreTecnico= nombreTecnico;
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
    public long cantidadDeIncidentesResueltos (){
        return this.getIncidentes().stream().filter(caso ->  caso.getEstadoIncidente().equals(State.RESUELTO)).count();
    }
}
