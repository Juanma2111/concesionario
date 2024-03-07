package com.iessoterohernandez.concesionario.models;

import javax.persistence;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private Date fechaAlta;

    // Constructores, getters y setters
}
