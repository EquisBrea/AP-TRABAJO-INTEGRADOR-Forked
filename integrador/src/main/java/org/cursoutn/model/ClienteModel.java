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
    @GeneratedValue
    private int id;
    @Column
    private String razon_social;
    @Column
    private long cuil;
    @OneToMany
    @MapsId
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<NotificacionModel> notificaciones;
    @OneToMany
    @MapsId
    @JoinColumn(name="cliente_id",referencedColumnName = "id")
    private List<ServicioModel> servicio;
    @OneToMany
    @MapsId
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    private List<IncidenteModel> incidentes;

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
