package com.desafiobackend.desafio.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafiobackend.desafio.entities.Cidade;
import com.desafiobackend.desafio.entities.Cliente;
import com.desafiobackend.desafio.entities.Estado;
import com.desafiobackend.desafio.entities.enums.Sexo;
import com.desafiobackend.desafio.repositories.CidadeRepository;
import com.desafiobackend.desafio.repositories.ClienteRepository;
import com.desafiobackend.desafio.repositories.EstadoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Atila Izac", Sexo.valueOf("MASCULINO"), Date.from(Instant.parse("1993-12-31T00:00:00Z")));
		Cliente c2 = new Cliente(null, "Joana Silva", Sexo.valueOf("FEMININO"), Date.from(Instant.parse("1993-12-31T00:00:00Z")));
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Campinas", e2);
		Cidade cid2 = new Cidade(null, "Mogi Mirim", e2);
		Cidade cid3 = new Cidade(null, "Ouro Fino", e1);
		
//		e1.getCidades().addAll(Arrays.asList(cid3));
//		e2.getCidades().addAll(Arrays.asList(cid1, cid2));
		
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
	}
}
