package com.rogeriofrsouza.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogeriofrsouza.course.entities.User;

@RestController  // Indica que a classe é um recurso web, implementado por um controlador Rest
@RequestMapping(value = "/users")  // Nome e caminho do recurso 
public class UserResource {

	@GetMapping  // Responde a requisição GET do HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1, "Maria", "maria@gmail.com", "123456", "123456");
		
		/*
		 * ResponseEntity (generics) retorna respostas de requisições web
		 * Retorna a resposta de sucesso, incluindo o como corpo da resposta
		 */
		return ResponseEntity.ok().body(u);
	}
}
