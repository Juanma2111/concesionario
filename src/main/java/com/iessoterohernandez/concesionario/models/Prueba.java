package com.iessoterohernandez.concesionario.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prueba {
	@NotNull
    @ManyToOne
    private Cliente cliente;
	@NotNull
    @ManyToOne
    private Vehiculo vehiculo;
	@NotNull
    private Date fechaHora;
	@NotNull
    private Boolean realizada;

    public Prueba() {
    }

    public Prueba(Cliente cliente, Vehiculo vehiculo, Date fechaHora, Boolean realizada) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaHora = fechaHora;
        this.realizada = realizada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }
}
