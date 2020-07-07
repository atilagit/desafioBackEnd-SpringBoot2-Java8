package com.desafiobackend.desafio.services.exceptions;

public class ExcecaoDeDuplicidadeDeRecurso extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcecaoDeDuplicidadeDeRecurso(Object obj) {
		super("O recurso já existe no sistema. " + obj);
	}
}
