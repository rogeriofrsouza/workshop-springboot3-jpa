package com.rogeriofrsouza.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rogeriofrsouza.course.entities.User;
import com.rogeriofrsouza.course.repositories.UserRepository;

@Configuration  // Classe específica de configuração
// @Profile("test")  // Mesmo perfil definido no application.properties
public class TestConfig implements CommandLineRunner {
	
	/*
	 * Injeção de dependência -> Deve ser fraca, desacoplada (SOLID)
	 * Framework possui um mecanismo de injeção implícito/automático
	 */
	@Autowired  // Faz a associação de uma instância de UserRepository
	private UserRepository userRepository;
	
	// Execução quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		// Database seeding -> instanciação do banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
}
