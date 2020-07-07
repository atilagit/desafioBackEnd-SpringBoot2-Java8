package com.desafiobackend.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.desafiobackend.desafio.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	@Transactional(readOnly = true)
	Estado findBynomeIgnoreCase(String nome);
}
