package com.desafiobackend.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiobackend.desafio.dto.EstadoDTO;
import com.desafiobackend.desafio.entities.Estado;
import com.desafiobackend.desafio.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll(){
		List<Estado> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EstadoDTO> findById(@PathVariable Long id){
		Estado obj = service.findById(id);
		EstadoDTO objDto = service.estadoToDto(obj);
		return ResponseEntity.ok().body(objDto);
	}
}
