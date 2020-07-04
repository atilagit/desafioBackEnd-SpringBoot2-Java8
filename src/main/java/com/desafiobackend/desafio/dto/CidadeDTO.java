package com.desafiobackend.desafio.dto;

import java.io.Serializable;

public class CidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	
	public CidadeDTO() {
	}

	public CidadeDTO(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
