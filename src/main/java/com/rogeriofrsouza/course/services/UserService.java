package com.rogeriofrsouza.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rogeriofrsouza.course.entities.User;
import com.rogeriofrsouza.course.repositories.UserRepository;
import com.rogeriofrsouza.course.services.exceptions.DatabaseException;
import com.rogeriofrsouza.course.services.exceptions.ResourceNotFoundException;

@Service  // Registra a classe como um componente do Spring, podendo ser injetada automaticamente pelo @Autowired
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		
		// Retorna o objeto contido no Optional com get() ou lança uma exceção
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			findById(id);
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());  // Lança uma exceção de serviço personalizada
		}
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
