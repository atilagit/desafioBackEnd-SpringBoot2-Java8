package com.desafiobackend.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiobackend.desafio.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
}
