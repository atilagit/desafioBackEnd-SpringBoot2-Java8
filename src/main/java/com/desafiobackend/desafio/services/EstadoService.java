package com.desafiobackend.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiobackend.desafio.entities.Estado;
import com.desafiobackend.desafio.repositories.EstadoRepository;
import com.desafiobackend.desafio.services.exceptions.ExcecaoDeRecursoNaoEncontrado;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll(){
		return repository.findAll();
	}
	
	public Estado findById(Long id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ExcecaoDeRecursoNaoEncontrado(id));
	}
	
	public Estado insert(Estado obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Estado consultaPorNome(String nome){
		return repository.findBynomeIgnoreCase(nome);
	}
}
