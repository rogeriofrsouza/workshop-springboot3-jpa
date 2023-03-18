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
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public User update(Integer id, User obj) {
		User entity = repository.getReferenceById(id);  // Entidade monitorada pelo JPA
		updateData(entity, obj);  // Atualiza os dados do entity, baseado no obj
		
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		// Não atualiza todos os campos do usuário
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
