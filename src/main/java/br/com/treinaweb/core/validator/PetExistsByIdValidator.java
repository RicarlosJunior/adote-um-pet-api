package br.com.treinaweb.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinaweb.core.repository.PetRepository;

//Classe que tem a logica de negocio de validaçao

@Component
public class PetExistsByIdValidator implements ConstraintValidator<PetExistsById, Long> {

	@Autowired
	private PetRepository petRepository;
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if(value == null) {
			return true;
		}
		return petRepository.existsById(value);
	}

}
