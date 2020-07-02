package com.desafiobackend.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiobackend.desafio.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
