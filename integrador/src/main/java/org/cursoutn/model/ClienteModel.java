package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.cursoutn.repository.JpaClienteRepository;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class ClienteModel {
    private JpaClienteRepository repository;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String razon_social;

    @Column(nullable = false)
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
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private List<IncidenteModel> incidentes;

    public ClienteModel() {
    }

    public ClienteModel(JpaClienteRepository repository, int id, String razon_social, long cuil, List<NotificacionModel> notificaciones,
                        List<ServicioModel> servicios, List<IncidenteModel> incidentes) {
        this.repository = repository;
        this.id = id;
        this.razon_social = razon_social;
        this.cuil = cuil;
        this.notificaciones = notificaciones;
        this.servicios = servicios;
        this.incidentes = incidentes;
    }

    //Para crear un cliente por primera vez
    public ClienteModel(int id, String razon_social, long cuil) {
        this.id = id;
        this.razon_social = razon_social;
        this.cuil = cuil;
    }

    public void guardarCliente (ClienteModel cliente) throws Exception {
            repository.guardarCliente(cliente);
    }
    public ClienteModel obtenerClientePorId(int id) throws Exception {
        return repository.obtenerClientePorId(id);
    }
    public void actualizarCliente(ClienteModel cliente) throws Exception {
        repository.actualizarCliente(cliente);
    }
    public void eliminarCliente(ClienteModel cliente) throws Exception {repository.eliminarCliente(cliente);}
}
