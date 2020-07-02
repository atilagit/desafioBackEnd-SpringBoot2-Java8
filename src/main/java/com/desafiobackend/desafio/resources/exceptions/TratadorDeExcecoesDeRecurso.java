package com.desafiobackend.desafio.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafiobackend.desafio.services.exceptions.ExcecaoDeRecursoNaoEncontrado;

@ControllerAdvice
public class TratadorDeExcecoesDeRecurso {
	
	@ExceptionHandler(ExcecaoDeRecursoNaoEncontrado.class)
	public ResponseEntity<PadraoErro> recursoNaoEncontrado(ExcecaoDeRecursoNaoEncontrado e, HttpServletRequest request){
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		PadraoErro err = new PadraoErro(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
