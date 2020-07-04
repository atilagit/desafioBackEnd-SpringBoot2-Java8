package com.desafiobackend.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiobackend.desafio.entities.Cliente;
import com.desafiobackend.desafio.repositories.ClienteRepository;
import com.desafiobackend.desafio.services.exceptions.ExcecaoDeRecursoNaoEncontrado;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CidadeService cidadeService;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ExcecaoDeRecursoNaoEncontrado(id));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj.setIdade(null);
		obj.setCidadeOndeMora(cidadeService.findById(obj.getCidadeOndeMora().getId()));
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ExcecaoDeRecursoNaoEncontrado(id);
		}
	}
}
