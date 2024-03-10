package com.iessoterohernandez.concesionario.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iessoterohernandez.concesionario.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNif(String nif);

    boolean existsByNif(String nif);

    @Query("SELECT COUNT(p) FROM Prueba p WHERE p.cliente.id = :clienteId")
    Integer pruebasByClienteId(Long clienteId);
}
