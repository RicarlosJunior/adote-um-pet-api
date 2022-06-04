package br.com.treinaweb.core.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.core.dto.pet.PetResponse;
import br.com.treinaweb.core.dto.pet.PetMapper;
import br.com.treinaweb.core.model.Pet;
import br.com.treinaweb.core.repository.PetRepository;

@RestController
public class PetController {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetMapper petMapper; //Classe (Bean Spring Component) que mapeia um pet model em um dto para resposta
	
	@GetMapping("/api/pets")
	public List<PetResponse> findAll(){
		var pets = petRepository.findAll();
		var petsResponse = new ArrayList<PetResponse>();
		for (Pet pet : pets) {
			petsResponse.add(petMapper.toResponse(pet));
		}
		return petsResponse;
	}
	
}
