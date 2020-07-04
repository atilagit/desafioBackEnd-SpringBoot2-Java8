package com.desafiobackend.desafio.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.desafiobackend.desafio.entities.enums.Sexo;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer sexo;
	private LocalDate dataDeNascimento;
	private Integer idade;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidadeOndeMora;
	
	public Cliente(){
	}

	public Cliente(Long id, String nome, Sexo sexo, LocalDate dataDeNascimento, Cidade cidadeOndeMora) {
		super();
		this.id = id;
		this.nome = nome;
		setSexo(sexo);
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idadeAtual();
		this.cidadeOndeMora = cidadeOndeMora;
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

	public Sexo getSexo() {
		return Sexo.valueOf(sexo);
	}

	public void setSexo(Sexo sexo) {
		if(sexo != null) {
			this.sexo = sexo.getCode();
		}
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Integer getIdade() {
		setIdade(idadeAtual());
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Cidade getCidadeOndeMora() {
		return cidadeOndeMora;
	}

	public void setCidadeOndeMora(Cidade cidadeOndeMora) {
		this.cidadeOndeMora = cidadeOndeMora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	private Integer idadeAtual() {
		LocalDate hj = LocalDate.now();
		if(dataDeNascimento != null) {
			return Period.between(dataDeNascimento, hj).getYears();
		}
		return null;
	}
}
