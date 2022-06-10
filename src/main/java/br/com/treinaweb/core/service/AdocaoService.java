package br.com.treinaweb.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.treinaweb.core.dto.adocao.AdocaoMapper;
import br.com.treinaweb.core.dto.adocao.AdocaoRequest;
import br.com.treinaweb.core.dto.adocao.AdocaoResponse;
import br.com.treinaweb.core.repository.AdocaoRepository;

//Classe responsavel pelas logicas de nogocio da nossa aplicaçao

@Service
public class AdocaoService {

	@Autowired
	private AdocaoRepository adocaoRepository;
	
	@Autowired
	private AdocaoMapper adocaoMapper;
	
	
	public AdocaoResponse create(@RequestBody AdocaoRequest adocaoRequest) {
		var adocao = adocaoMapper.toModel(adocaoRequest);
		var createdAdocao = adocaoRepository.save(adocao);
		return adocaoMapper.toResponse(createdAdocao);
	}
	
	public List<AdocaoResponse> findAll(){
		return adocaoRepository.findAll()
								.stream()
								.map(adocaoMapper::toResponse)
								.toList();
		
	}
	
}
