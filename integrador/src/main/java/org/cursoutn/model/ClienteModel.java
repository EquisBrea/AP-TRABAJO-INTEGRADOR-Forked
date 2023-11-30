package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.Par;
import org.cursoutn.repository.JpaClienteRepository;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

import static org.cursoutn.Consultas.devolverArrayDeStrings;
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

    @Column(nullable = false, columnDefinition = "varchar (255) default XBSystems")
    private String razon_social;

    @Column
    private long cuil;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id",referencedColumnName = "id")
    private NotificacionModel notificacion;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<ServicioModel> servicios;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<IncidenteModel> incidentes;

    public ClienteModel() {
        this.razon_social = "";
        this.cuil = 0;
        this.notificacion = new NotificacionModel();
        this.servicios = new ArrayList<>();
        this.incidentes = new ArrayList<>();
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
    public List<Par<Integer, String>> listarClientesPorId () throws Exception {
        JpaClienteRepository repository = new JpaClienteRepository();

        List<Par<Integer, String>> pares = new ArrayList<>();
        repository.obtenerTodosLosClientes().stream().forEach(problemas ->
        {
            int id = problemas.getId();
            String nombreProblema = problemas.getRazon_social();
            pares.add(new Par<>(id, nombreProblema));
        });

        return pares;

    }
}





