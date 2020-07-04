package com.desafiobackend.desafio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiobackend.desafio.dto.CidadeDTO;
import com.desafiobackend.desafio.dto.EstadoDTO;
import com.desafiobackend.desafio.entities.Cidade;
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

	public EstadoDTO estadoToDto(Estado obj) {
		EstadoDTO objDto = new EstadoDTO(obj.getId(), obj.getNome(), cidadeToDto(obj.getCidades()));
		return objDto;
	}
	
	private List<CidadeDTO> cidadeToDto(Set<Cidade> listCid){
		List<CidadeDTO> listCidDto = new ArrayList<>();
		for (Cidade cidade : listCid) {
			listCidDto.add(new CidadeDTO(cidade.getId(), cidade.getNome()));
		}
		listCidDto.sort((c1,c2) -> c1.getNome().toUpperCase().compareTo(c2.getNome().toUpperCase()));
		return listCidDto;
	}
}
