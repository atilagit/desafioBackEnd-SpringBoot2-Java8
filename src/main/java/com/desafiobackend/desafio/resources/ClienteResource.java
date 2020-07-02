package com.desafiobackend.desafio.resources;

import java.time.Instant;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiobackend.desafio.entities.Cliente;
import com.desafiobackend.desafio.entities.enums.Sexo;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@GetMapping
	public ResponseEntity<Cliente> findAll(){
		Cliente cli = new Cliente(1L, "Atila Izac", Sexo.valueOf("MASCULINO"), Date.from(Instant.parse("1993-12-31T00:00:00Z")));
		return ResponseEntity.ok().body(cli);
	}
}
