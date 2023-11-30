package org.cursoutn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="notificacion")
public class NotificacionModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar (255) default 'Correo electronico'")
    private String nombreNotificacion;

    @ManyToMany
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private List<ClienteModel> cliente;

    public NotificacionModel() {
    }

    public NotificacionModel(String nombreNotificacion, List<ClienteModel> cliente) {
        this.nombreNotificacion = nombreNotificacion;
        this.cliente = cliente;
    }


}
