package br.com.treinaweb.core.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Gera get/Set ToString HashCode e Equals
@NoArgsConstructor //Gera um construtor sem argumentos 
@AllArgsConstructor //Gera um construtor com todos os argumentos
public class PetResponse {

	private Long id;
	private String nome;
	private String historia;
	private String foto;
	
}
