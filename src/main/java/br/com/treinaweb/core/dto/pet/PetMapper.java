package br.com.treinaweb.core.dto.pet;

import org.springframework.stereotype.Component;

import br.com.treinaweb.core.model.Pet;

@Component
public class PetMapper {

	public PetResponse toResponse(Pet pet) {
		//1°Versão sem padrao de projeto builder 
		/*PetResponse petResponse = new PetResponse();
		petResponse.setId(pet.getId());
		petResponse.setNome(pet.getNome());
		petResponse.setHistoria(pet.getHistoria());
		petResponse.setFoto(pet.getFoto());
		return petResponse;*/
		
		//2°Versão com padrao de projeto builder (padroes de projetos de categoria criacional) 
		return PetResponse.builder()
				.id(pet.getId())
				.nome(pet.getNome())
				.historia(pet.getHistoria())
				.foto(pet.getFoto())
				.build();
		
	}
	
	public Pet toModel(PetRequest petRequest) {
		return Pet.builder()
				.nome(petRequest.getNome())
				.historia(petRequest.getHistoria())
				.foto(petRequest.getFoto())
				.build();
	}
	
}
