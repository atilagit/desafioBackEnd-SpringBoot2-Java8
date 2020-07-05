package com.desafiobackend.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafiobackend.desafio.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	@Query("SELECT obj FROM Cidade obj WHERE obj.estado.nome LIKE %:estado%")
	List<Cidade> consultaPorEstado(@Param("estado") String estado);
	
}
