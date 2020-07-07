package com.desafiobackend.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafiobackend.desafio.entities.Cidade;
import com.desafiobackend.desafio.entities.Estado;
import com.desafiobackend.desafio.repositories.CidadeRepository;
import com.desafiobackend.desafio.services.exceptions.ExcecaoDeDuplicidadeDeRecurso;
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
		List<Cidade> list = repository.findBynome(obj.getNome());
		if(list.contains(obj)) {
			obj = list.get(list.indexOf(obj));
			throw new ExcecaoDeDuplicidadeDeRecurso(obj.toString()); //posteriormente talvez eu lance uma exceção aqui
		}
		return repository.save(tratamentoParaInsert(obj));
	}
	
	public List<Cidade> consultaPorEstado(String estado){
		return repository.consultaPorEstado(estado);
	}
	
	public List<Cidade> consultaPorNome(String nome){
		return repository.findBynomeContainingIgnoreCase(nome);
	}

	private Cidade tratamentoParaInsert(Cidade obj) {
		obj.setId(null);
		obj.getEstado().setId(null);
		Estado entity = estadoService.consultaPorNome(obj.getEstado().getNome());
		if(obj.getEstado().getNome().equals(entity.getNome())) {
			obj.setEstado(entity);
		}else {
			obj.setEstado(estadoService.insert(obj.getEstado()));
		}
		return obj;
	}
}
