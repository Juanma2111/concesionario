package com.iessoterohernandez.concesionario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iessoterohernandez.concesionario.models.Concesionario;

public interface ConcesionarioRepository extends JpaRepository<Concesionario, Long>{
    
}
