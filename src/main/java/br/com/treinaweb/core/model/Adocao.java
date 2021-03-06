package br.com.treinaweb.core.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.treinaweb.core.dto.adocao.AdocaoResponse;
import br.com.treinaweb.core.dto.pet.PetResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder //para usarmos esse design pattern e o obrigatorio que a gente tenha um construtor com todos os argumentos (@AllArgsConstructor e obrigatória) 
public class Adocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	@Column(nullable = false)
	private BigDecimal valor;
	@Column(nullable = false)
	private String email;
	@ManyToOne(optional = true) //optional = true indica que a propiedade é obrigatoria, ou seja não é possivel criar uma doação sem o pet
	private Pet pet;
}
