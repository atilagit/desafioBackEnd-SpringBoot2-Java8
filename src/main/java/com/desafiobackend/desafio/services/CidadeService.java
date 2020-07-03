package com.desafiobackend.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiobackend.desafio.entities.Cidade;
import com.desafiobackend.desafio.entities.Estado;
import com.desafiobackend.desafio.repositories.CidadeRepository;
import com.desafiobackend.desafio.services.exceptions.ExcecaoDeRecursoNaoEncontrado;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	@Autowired
	private EstadoService estadoService;
	
	public List<Cidade> findAll(){
		return repository.findAll();
	}
	
	public Cidade findById(Long id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ExcecaoDeRecursoNaoEncontrado(id));
	}
	
	@Transactional
	public Cidade insert(Cidade obj) {
		List<Cidade> listCid = findAll();
		if(listCid.contains(obj)) {
			return listCid.get(listCid.indexOf(obj));
		}
		List<Estado> listEst = estadoService.findAll();
		if(listEst.contains(obj.getEstado())) {
			int index = listEst.indexOf(obj.getEstado());
			obj.setEstado(listEst.get(index));
		}else {
			obj.setEstado(estadoService.insert(obj.getEstado()));
		}
		return repository.save(obj);
	}
}
