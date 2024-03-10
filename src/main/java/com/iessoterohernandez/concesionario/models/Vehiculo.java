package com.iessoterohernandez.concesionario.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;

@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String numeroBastidor;
    @NotNull
    @Column(unique = true)
    private String matricula;
    @NotNull
    private String marca;
    @NotNull
    private String modelo;
    private Integer potencia;
    private Integer cilindrada;
    @NotNull
    private Double precioVenta;
    private Integer anoFabricacion;

    public Vehiculo() {}

    public Vehiculo(String numBas, String matricula, String marca, String modelo, Integer potencia, Integer cilindrada, Double precio, Integer anoFab) {
        this.numeroBastidor = numBas;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.precioVenta = precio;
        this.anoFabricacion = anoFab;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroBastidor() {
        return numeroBastidor;
    }

    public void setNumeroBastidor(String numeroBastidor) {
        this.numeroBastidor = numeroBastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }
}
