package com.desafiobackend.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.desafiobackend.desafio.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Transactional(readOnly = true)
	List<Cliente> findBynomeContainingIgnoreCase(String nome);
}
