package br.com.treinaweb.core.dto.pet;

import org.springframework.stereotype.Component;

import br.com.treinaweb.core.model.Pet;

@Component
public class PetMapper {

	public PetResponse toResponse(Pet pet) {
		PetResponse petResponse = new PetResponse();
		petResponse.setId(pet.getId());
		petResponse.setNome(pet.getNome());
		petResponse.setHistoria(pet.getHistoria());
		petResponse.setFoto(pet.getFoto());
		return petResponse;
	}
	
}
