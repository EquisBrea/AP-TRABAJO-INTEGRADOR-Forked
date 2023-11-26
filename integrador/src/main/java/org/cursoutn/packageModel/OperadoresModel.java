package org.cursoutn.packageModel;

import jakarta.persistence.*;

@Entity
@Table(name="operadores")
public class OperadoresModel {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String nombreOperador;
}
