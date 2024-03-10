package com.iessoterohernandez.concesionario.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Concesionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String nombre;
    @NotNull
    private String direccion;
    @NotNull
    @Column(unique = true)
    private String email;
    private String horario;
    @NotNull
    @Column(unique = true)
    private String telefono;
    @NotNull
    private Integer anoApertura;

    public Concesionario() {}

    public Concesionario(String nombre, String direccion, String email, String horario, String telefono, Integer anoAp) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.horario = horario;
        this.telefono = telefono;
        this.anoApertura = anoAp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getAnoApertura() {
        return anoApertura;
    }

    public void setAnoApertura(Integer anoApertura) {
        this.anoApertura = anoApertura;
    }
}
