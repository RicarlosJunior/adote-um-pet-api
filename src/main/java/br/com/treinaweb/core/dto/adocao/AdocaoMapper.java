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
		//1°Versão sem padrao de projeto builder 
		/*var adocao = new Adocao();
		adocao.setEmail(adocaoRequest.getEmail());
		adocao.setValor(adocaoRequest.getValor());
		adocao.setPet(petRepository.findByIdOrElseThrow(adocaoRequest.getIdPet()));
		return adocao;*/
		
		//2°Versão com padrao de projeto builder (padroes de projetos de categoria criacional) 
		return Adocao.builder()
				.email(adocaoRequest.getEmail())
				.valor(adocaoRequest.getValor())
				.pet(petRepository.findByIdOrElseThrow(adocaoRequest.getIdPet()))
				.build();
	}
	
	
	public AdocaoResponse toResponse(Adocao adocao) {
		//1°Versão sem padrao de projeto builder 
		/*var adocaoResponse = new AdocaoResponse();
		adocaoResponse.setId(adocao.getId());
		adocaoResponse.setEmail(adocao.getEmail());
		adocaoResponse.setValor(adocao.getValor());
		adocaoResponse.setPetResponse(petMapper.toResponse(adocao.getPet()));
		return adocaoResponse;*/
		return AdocaoResponse.builder()
				.id(adocao.getId())
				.email(adocao.getEmail())
				.valor(adocao.getValor())
				.petResponse(petMapper.toResponse(adocao.getPet()))
				.build();
	}
	
}
