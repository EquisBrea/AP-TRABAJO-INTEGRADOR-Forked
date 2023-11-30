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
@Entity
@Table(name="cliente")
public class ClienteModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String razon_social;

    @Column
    private long cuil;

    @ManyToOne
    @JoinColumn(name = "notificacion_id", referencedColumnName = "id")
    private NotificacionModel notificacion;


    @ManyToMany(mappedBy = "clientes")
    private List<ServicioModel> servicios;

    @OneToMany
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<IncidenteModel> incidentes;

    public ClienteModel() {
    }

    public ClienteModel(String razon_social, Long cuil, NotificacionModel notificacion,
                        List<ServicioModel> servicios, List<IncidenteModel> incidentes) {
        this.razon_social = razon_social;
        this.cuil = cuil;
        this.notificacion = notificacion;
        this.servicios = servicios;
        this.incidentes = incidentes;
    }

    //Para crear un cliente por primera vez
    public ClienteModel(String razon_social, Long cuil) {
        this.razon_social = razon_social;
        this.cuil = cuil;
    }
}





