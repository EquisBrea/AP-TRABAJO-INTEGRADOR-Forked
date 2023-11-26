package org.cursoutn.model;

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
