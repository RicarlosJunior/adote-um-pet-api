package br.com.treinaweb.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.core.exception.PetNotFoundException;
import br.com.treinaweb.core.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	default Pet findByIdOrElseThrow(Long id) {

//		1° Versao  sem refatoração
//		var petOptional = findById(id);
//		if(petOptional.isPresent()) {
//			return petOptional.get();
//		}
//		throw new EntityNotFoundException("Pet não encontrado!");
		
//		2° Versao com refatoração e usando nossa classe de excepiton para Pet
//		return findById(id)
//				.orElseThrow(() -> new PetNotFoundException());
		
//		3° Versao com refatoração e mehod reference (passa o nome da classe seguido de 2x :: nome do mentodo nesse caso estamos chamando o metodo construtor)
		return findById(id)
				.orElseThrow(PetNotFoundException::new);
		
	}
	
}
