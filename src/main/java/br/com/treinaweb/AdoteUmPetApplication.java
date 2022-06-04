package br.com.treinaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.treinaweb.core.model.Pet;
import br.com.treinaweb.core.repository.PetRepository;

@SpringBootApplication
public class AdoteUmPetApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AdoteUmPetApplication.class, args);
	}

	
	//Apos a implementação da interface CommandLineRunner
	//Metodo abaixo e execultado quando a aplicação estiver acabado de startar
	//neste exemplo toda vez que a aplicação subir vamo criar alguns pets para teste
	
	@Override
	public void run(String... args) throws Exception {
		
		Pet pet = new Pet();
		pet.setNome("Pulguinha");
		pet.setHistoria("Essa cachorrinha é muito dócil, carinhosa e amada por todos,"
						+ "	tem uma historia incrível, é conhecida inclusive com heroína na comunidade,"
						+ " salvou um idoso de um assalto, colocando os bandidos para correr! 'Corre ladrão. Corre ladrão' ");
		pet.setFoto("https://i.pinimg.com/736x/1d/71/96/1d7196c32a1b6ebdf886c357d7ed6599.jpg");
		
		petRepository.save(pet);
		
		
		pet = new Pet();
		pet.setNome("Duki");
		pet.setHistoria("Esse cachorro é uma peça!!! Não pode ver uma moto que sai doido atrás."
						+ "	É muito enérgico, gosta de correr 'Principalmente atrás de motos rsrs', mas é também um ótimo parceirinho ");
		pet.setFoto("https://th.bing.com/th/id/R.3128b5dde9d6411582511d3c4dae75e5?rik=zotHKgC8l32F%2fw&riu=http%3a%2f%2fc1.quickcachr.fotos.sapo.pt%2fi%2fo46017d99%2f5895897_O7C8a.jpeg&ehk=n9KGFXf2l3WN8otkwauCt9iS9tP1A9VOV5g7FBL1m9Y%3d&risl=&pid=ImgRaw&r=0");
		
		petRepository.save(pet);
		
		
		pet = new Pet();
		pet.setNome("Risadinha");
		pet.setHistoria("Risadinha dispensa apresentações apesar de sua raça ser considerada violenta,"
						+ "	Risadinha vem quebrando esse mito, muito dócil e arteiro Risadinha como e conhecido esbanja carisma e chama atenção, tendo, inclusive, um perfil em uma rede social ");
		pet.setFoto("https://img.freepik.com/fotos-gratis/o-cao-american-bully-cor-marrom-chocolate-esta-sorrindo-na-grama-verde-cao-de-tamanho-medio-com-corpo-musculoso-e-compacto-cabeca-em-bloco-e-estrutura-ossea-pesada_231786-3192.jpg?w=740");
		
		petRepository.save(pet);
		
		
	}

}
