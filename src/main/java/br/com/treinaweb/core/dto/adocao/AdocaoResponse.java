package br.com.treinaweb.core.dto.adocao;

import java.math.BigDecimal;

import br.com.treinaweb.core.dto.pet.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //para usarmos esse design pattern e o obrigatorio que a gente tenha um construtor com todos os argumentos (@AllArgsConstructor e obrigatória) 
public class AdocaoResponse {

	private Long id;
	private BigDecimal valor;
	private String email;
	private PetResponse petResponse;
	
}
