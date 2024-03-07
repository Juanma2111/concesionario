package com.iessoterohernandez.concesionario.models;

import javax.persistence.*;

@Entity
public class Concesionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccionPostal;
    private String email;
    private String horario;
    private String telefono;
    private Integer anoApertura;

}
