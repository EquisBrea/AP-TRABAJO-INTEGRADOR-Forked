package org.cursoutn.model;

import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class ClienteModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String razon_social;
    @Column
    private long cuil;


}
