package br.com.treinaweb.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")   //Adicionando parametros de rotas
					.allowedOrigins("*") //Permitindo que todas as origens tenha acesso
					.allowedMethods("*") // Verbos http que a api aceita nesse caso todas
					.allowedHeaders("*"); //Todos os cabeçalhos
	}				

}
