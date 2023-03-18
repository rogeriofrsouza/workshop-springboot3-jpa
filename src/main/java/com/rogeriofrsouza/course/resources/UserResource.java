package com.rogeriofrsouza.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rogeriofrsouza.course.entities.User;
import com.rogeriofrsouza.course.services.UserService;

@RestController  // Indica que a classe é um recurso web, implementado por um controlador Rest
@RequestMapping(value = "/users")  // Nome e caminho do recurso 
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping  // Endpoint -> responde a requisição GET do HTTP
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		
		/*
		 * ResponseEntity (generics) retorna respostas de requisições web
		 * Retorna a resposta de sucesso do HTTP e inclui a lista no corpo da resposta
		 */
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")  // Recebe um parâmetro da url (id)
	public ResponseEntity<User> findById(@PathVariable Integer id) {  // Reconhece o id como uma variável da URL
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping  // Insere um novo recurso no banco de dados
	public ResponseEntity<User> insert(@RequestBody User obj) {  // O obj recebido em formato JSON é desserializado para User
		obj = service.insert(obj);
		
		// Padrão HTTP -> Ao retornar um status 201, espera-se o cabeçalho location (URI) contendo o endereço do novo recurso
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);  // Retornar o status 201 -> código específico do HTTP que indica a criação de um novo recurso
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();  // Retornar uma resposta sem conteúdo, com o código HTTP específico: 204 
	}
}
