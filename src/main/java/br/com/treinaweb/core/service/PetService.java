package br.com.treinaweb.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.core.dto.pet.PetMapper;
import br.com.treinaweb.core.dto.pet.PetRequest;
import br.com.treinaweb.core.dto.pet.PetResponse;
import br.com.treinaweb.core.repository.PetRepository;

//Classe responsavel pelas logicas de nogocio da nossa aplicaçao

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetMapper petMapper; //Classe reconhecida pelo Spring como (Bean Spring  devido a anotação Component) que mapeia um pet model em um dto para resposta
	
	public List<PetResponse> findAll(){
		
//		1° Versão
//		var pets = petRepository.findAll();
//		var petsResponse = new ArrayList<PetResponse>();
//		for (Pet pet : pets) {
//			petsResponse.add(petMapper.toResponse(pet));
//		}
//		return petsResponse;
		
//		2°Versão com refatoração e API Stream
//		return petRepository.findAll()
//				.stream()
//				.map((pet) -> petMapper.toResponse(pet)) //map transforma um tipo em outro nesse nosso exemplo transforma um pet em  um petResponse (retorna uma stream)
//				.collect(Collectors.toList()); //converte uma stream em uma lista nesse exemplo

//		3° Versao com refatoração e API Stream
		return petRepository.findAll()
				.stream()
				.map(petMapper::toResponse)
				.toList();
	}
	
	
	public PetResponse create(PetRequest petRequest) {
		var pet = petMapper.toModel(petRequest);
		var createdPet = petRepository.save(pet);
		return petMapper.toResponse(createdPet); 
	}
	
}
