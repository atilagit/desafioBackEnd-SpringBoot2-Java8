package com.desafiobackend.desafio.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	private List<CidadeDTO> cidades = new ArrayList<>();

	public EstadoDTO() {
	}

	public EstadoDTO(Long id, String nome, List<CidadeDTO> cidades) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidades = cidades;
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

	public List<CidadeDTO> getCidades() {
		return cidades;
	}

	public void setCidades(List<CidadeDTO> cidades) {
		this.cidades = cidades;
	}
}
