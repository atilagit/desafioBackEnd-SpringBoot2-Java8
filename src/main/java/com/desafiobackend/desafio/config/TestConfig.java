package com.desafiobackend.desafio.config;

import java.time.LocalDate;
import java.util.Arrays;

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
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Campinas", e2);
		Cidade cid2 = new Cidade(null, "Mogi Mirim", e2);
		Cidade cid3 = new Cidade(null, "Ouro Fino", e1);
				
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		 
		Cliente c1 = new Cliente(null, "Atila Izac", Sexo.valueOf("MASCULINO"), LocalDate.parse("1993-12-31"), cid1);
		Cliente c2 = new Cliente(null, "Joana Silva", Sexo.valueOf("FEMININO"), LocalDate.parse("1993-12-31"), cid3);
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
	}
}
