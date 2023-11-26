package org.cursoutn.packageModel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="clientes")
public class ClientesModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String razon_social;
    @Column
    private int cuil;


}
