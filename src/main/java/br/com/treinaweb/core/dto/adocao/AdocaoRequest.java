package br.com.treinaweb.core.dto.adocao;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import br.com.treinaweb.core.validator.PetExistsById;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
@Builder //para usarmos esse design pattern e o obrigatorio que a gente tenha um construtor com todos os argumentos (@AllArgsConstructor e obrigatória) 
public class AdocaoRequest {

	@NotNull // nao aceita null
	@NotEmpty // nao aceita vazio
	@Email // so aceita email valido ou seja deve conter o caracter @ e o .
	@Size(max = 255) //so aceita email ate 255 caracter
	private String email;
	
	@NotNull // nao aceita null
	@Min(10) // valor minimo aceito e 10
	@Max(100) // valor maximo aceito e 100
	private BigDecimal valor;
	
	
	@NotNull // nao aceita null
	@Positive //So aceita valores positivos
	@PetExistsById //Anotação criada por nos para validar se o id do pet existe
	private Long idPet;
	
}
