package br.com.treinaweb.core.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

import br.com.treinaweb.core.dto.exception.ErrorResponse;

@RestControllerAdvice //Anotação que diz que essa classe vai ser usada por todos os controller da aplicação
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	
	private final SnakeCaseStrategy snakeCaseStrategy = new SnakeCaseStrategy();
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		
		var body = ErrorResponse.builder()
				.status(status.value())
				.error(status.getReasonPhrase())
				.cause(exception.getClass().getSimpleName())
				.message("Houveram erros de validação")
				.timestamp(LocalDateTime.now())
				.errors(convertFieldErrors(exception.getBindingResult().getFieldErrors()))
				.build();
		
		
		return new ResponseEntity<>(body, status);
	}
	
	
	private Map<String, List<String>> convertFieldErrors(List<FieldError> fieldErrors){
		var erros = new HashMap<String, List<String>>();
		
		fieldErrors.stream().forEach(fieldError ->{
			var field = snakeCaseStrategy.translate(fieldError.getField());
			if(erros.containsKey(field)) {
				erros.get(field).add(fieldError.getDefaultMessage());
			}else {
				erros.put(
						field,
						Stream.of(fieldError.getDefaultMessage()).collect(Collectors.toList()) //Obs usar .collect(Collectors.toList()) porque assim consigo manipular a lista e usar .toList() direto não e possivel alterar
				);
			}
		});
		
		
		return erros;
	}
}
	
