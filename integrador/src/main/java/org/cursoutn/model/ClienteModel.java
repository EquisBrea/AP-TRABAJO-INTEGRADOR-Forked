package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.repository.JpaClienteRepository;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

import static org.cursoutn.Main.getEntityManager;

@Getter
@Setter
@DynamicInsert
@Entity
@Table(name="cliente")
public class ClienteModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'Juan Perez'")
    private String razon_social;

    @Column(nullable = false, columnDefinition = "unsigned bigint default 12222222222")
    private long cuil;

    @OneToMany
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<NotificacionModel> notificaciones;


    @ManyToMany
    @JoinTable(
            name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "servicio_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    )
    private List<ServicioModel> servicios;

    @OneToMany
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<IncidenteModel> incidentes;

    public ClienteModel() {
    }

    public ClienteModel(String razon_social, Long cuil, List<NotificacionModel> notificaciones,
                        List<ServicioModel> servicios, List<IncidenteModel> incidentes) {
        this.razon_social = razon_social;
        this.cuil = cuil;
        this.notificaciones = notificaciones;
        this.servicios = servicios;
        this.incidentes = incidentes;
    }

    //Para crear un cliente por primera vez
    public ClienteModel(String razon_social, Long cuil) {
        this.razon_social = razon_social;
        this.cuil = cuil;
    }
}





