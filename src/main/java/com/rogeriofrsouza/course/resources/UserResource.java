package com.rogeriofrsouza.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogeriofrsouza.course.entities.User;
import com.rogeriofrsouza.course.services.UserService;

@RestController  // Indica que a classe é um recurso web, implementado por um controlador Rest
@RequestMapping(value = "/users")  // Nome e caminho do recurso 
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping  // Responde a requisição GET do HTTP
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		
		/*
		 * ResponseEntity (generics) retorna respostas de requisições web
		 * Retorna a resposta de sucesso do HTTP e inclui a lista no corpo da resposta
		 */
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")  // Recebe um parâmetro da url (id)
	public ResponseEntity<User> findById(@PathVariable Integer id) {  // Recebe o parâmetro no endpoint
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
