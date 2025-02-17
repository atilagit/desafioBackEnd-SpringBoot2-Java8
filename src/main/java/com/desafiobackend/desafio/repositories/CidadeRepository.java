package com.desafiobackend.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.desafiobackend.desafio.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	@Query("SELECT obj FROM Cidade obj WHERE UPPER(obj.estado.nome) LIKE UPPER(concat('%', :estado,'%'))")
	List<Cidade> consultaPorEstado(@Param("estado") String estado);
	
	@Transactional(readOnly = true)
	List<Cidade> findBynomeContainingIgnoreCase(String nome);
	
	@Transactional(readOnly = true)
	List<Cidade> findBynomeIgnoreCase(String nome);
}
