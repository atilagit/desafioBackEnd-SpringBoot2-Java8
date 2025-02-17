package com.desafiobackend.desafio.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafiobackend.desafio.entities.Cidade;
import com.desafiobackend.desafio.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll(){
		List<Cidade> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id){
		Cidade obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/busca-por-estado")
	public ResponseEntity<List<Cidade>> consultaPorEstado(@RequestParam(value="estado", defaultValue="") String estado){
		List<Cidade> obj = service.consultaPorEstado(estado);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/busca-por-nome")
	public ResponseEntity<List<Cidade>> consultaPorNome(@RequestParam(value="nome", defaultValue="") String nome){
		List<Cidade> obj = service.consultaPorNome(nome);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Cidade> insert(@RequestBody Cidade obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
