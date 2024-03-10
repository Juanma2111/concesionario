package com.iessoterohernandez.concesionario.repositories;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iessoterohernandez.concesionario.models.Prueba;

public interface PruebaRepository extends JpaRepository<Prueba, Long> {

    Optional<Prueba> findByClienteIdAndVehiculoIdAndFechaHora(Long clienteId, Long vehiculoId, Date fechaHora);
    
}
