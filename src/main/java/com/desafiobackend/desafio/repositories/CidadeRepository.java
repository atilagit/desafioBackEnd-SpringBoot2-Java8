package com.desafiobackend.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiobackend.desafio.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
}
