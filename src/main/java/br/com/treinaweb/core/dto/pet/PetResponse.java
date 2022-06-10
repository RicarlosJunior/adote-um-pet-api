package br.com.treinaweb.core.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder //para usarmos esse design pattern e o obrigatorio que a gente tenha um construtor com todos os argumentos (@AllArgsConstructor e obrigatória) 
public class PetResponse {

	private Long id;
	private String nome;
	private String historia;
	private String foto;
	
}
