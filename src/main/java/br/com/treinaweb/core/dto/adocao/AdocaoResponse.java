package br.com.treinaweb.core.dto.adocao;

import java.math.BigDecimal;

import br.com.treinaweb.core.dto.pet.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdocaoResponse {

	private Long id;
	private BigDecimal valor;
	private String email;
	private PetResponse petResponse;
	
}
