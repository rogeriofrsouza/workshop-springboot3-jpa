package com.rogeriofrsouza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rogeriofrsouza.course.entities.User;
import com.rogeriofrsouza.course.repositories.UserRepository;

@Service  // Registra a classe como um componente do Spring, podendo ser injetada automaticamente pelo @Autowired
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		
		// Retorna o objeto T contido no Optional
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
