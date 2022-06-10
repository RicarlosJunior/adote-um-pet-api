package br.com.treinaweb.core.exception;

import javax.persistence.EntityNotFoundException;

public class PetNotFoundException extends EntityNotFoundException {
	
	
	private static final long serialVersionUID = 1L;

	public PetNotFoundException() {
		super("Pet não encontrado");
	}

	public PetNotFoundException(String mensagem) {
		super(mensagem);
	}
	
}
