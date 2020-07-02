package com.desafiobackend.desafio.services.exceptions;

public class ExcecaoDeRecursoNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcecaoDeRecursoNaoEncontrado(Object id) {
		super("Recurso não encontrado. Id " + id);
	}
}
