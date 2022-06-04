package br.com.treinaweb.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.core.dto.adocao.AdocaoMapper;
import br.com.treinaweb.core.dto.adocao.AdocaoRequest;
import br.com.treinaweb.core.dto.adocao.AdocaoResponse;
import br.com.treinaweb.core.repository.AdocaoRepository;

@RestController
public class AdocaoController {

	@Autowired
	private AdocaoRepository adocaoRepository;
	
	@Autowired
	private AdocaoMapper adocaoMapper;
	
	@PostMapping("/api/adocoes")
	@ResponseStatus(code = HttpStatus.CREATED)
	public AdocaoResponse create(@RequestBody AdocaoRequest adocaoRequest) {
		var adocao = adocaoMapper.toModel(adocaoRequest);
		var createdAdocao = adocaoRepository.save(adocao);
		return adocaoMapper.toResponse(createdAdocao);
	}
}
