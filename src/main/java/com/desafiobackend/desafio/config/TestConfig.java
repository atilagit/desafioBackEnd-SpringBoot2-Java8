package com.desafiobackend.desafio.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafiobackend.desafio.entities.Cliente;
import com.desafiobackend.desafio.entities.enums.Sexo;
import com.desafiobackend.desafio.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Atila Izac", Sexo.valueOf("MASCULINO"), Date.from(Instant.parse("1993-12-31T00:00:00Z")));
		Cliente c2 = new Cliente(null, "Joana Silva", Sexo.valueOf("FEMININO"), Date.from(Instant.parse("1993-12-31T00:00:00Z")));
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
	}
}
