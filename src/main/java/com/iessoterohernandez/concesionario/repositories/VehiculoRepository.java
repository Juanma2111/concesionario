package com.iessoterohernandez.concesionario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iessoterohernandez.concesionario.models.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    
}
