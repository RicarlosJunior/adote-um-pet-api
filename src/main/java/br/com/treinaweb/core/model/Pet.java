package br.com.treinaweb.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


//Utilizaremos o lombok para deixar o codigo mais limpo
//sem ter que criar get/set construtor hashcode e equals
// tudo fornecido via anotaçao do lombok


//Anotaçao JPA
@Entity


//Anotacoes lombok
@Data //Gera get/set tostring hashcode e equals
@NoArgsConstructor //Gera um construtor sem argumentos 
@AllArgsConstructor //Gera um construtor com todos os argumentos
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //Essa anotação diz que eu vou definir os campos para equals e hashcode
@Builder //Anotaçao que nos permite usar o padrao de porjeto builder ja implementado no lombok
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Diz a banco para gerar o id
	@EqualsAndHashCode.Include
	private Long id;
	@Column(nullable = false) //Diz ao banco que essa coluna nao pode ser nula
	private String nome;
	@Column(nullable = false) //Diz ao banco que essa coluna nao pode ser nula
	private String historia;
	@Column(nullable = false) //Diz ao banco que essa coluna nao pode ser nula
	private String foto;
	
}
