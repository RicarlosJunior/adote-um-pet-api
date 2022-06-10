package br.com.treinaweb.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.core.dto.pet.PetRequest;
import br.com.treinaweb.core.dto.pet.PetResponse;
import br.com.treinaweb.core.service.PetService;

//Classe responsavel pelas requisiçoes e resposatas da nossa aplicacao

@RestController
@RequestMapping("/api/pets")
public class PetController {

	@Autowired
	private PetService petService;
	
	@GetMapping
	public List<PetResponse> findAll(){
		return petService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetResponse create(@RequestBody @Valid PetRequest petRequest) {
		return petService.create(petRequest);
	}
	
}
