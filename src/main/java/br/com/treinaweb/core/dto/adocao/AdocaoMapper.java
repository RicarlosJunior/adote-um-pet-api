package br.com.treinaweb.core.dto.adocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinaweb.core.dto.pet.PetMapper;
import br.com.treinaweb.core.model.Adocao;
import br.com.treinaweb.core.repository.PetRepository;

@Component
public class AdocaoMapper {

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private PetMapper petMapper;
	
	public Adocao toModel(AdocaoRequest adocaoRequest) {
		var adocao = new Adocao();
		adocao.setEmail(adocaoRequest.getEmail());
		adocao.setValor(adocaoRequest.getValor());
		adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getIdPet()));
		return adocao;
	}
	
	
	public AdocaoResponse toResponse(Adocao adocao) {
		var adocaoResponse = new AdocaoResponse();
		adocaoResponse.setId(adocao.getId());
		adocaoResponse.setEmail(adocao.getEmail());
		adocaoResponse.setValor(adocao.getValor());
		adocaoResponse.setPetResponse(petMapper.toResponse(adocao.getPet()));
		return adocaoResponse;
	}
	
}
