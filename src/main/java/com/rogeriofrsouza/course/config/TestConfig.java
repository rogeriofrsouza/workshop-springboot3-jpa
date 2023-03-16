package com.rogeriofrsouza.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rogeriofrsouza.course.entities.Category;
import com.rogeriofrsouza.course.entities.Order;
import com.rogeriofrsouza.course.entities.User;
import com.rogeriofrsouza.course.entities.enums.OrderStatus;
import com.rogeriofrsouza.course.repositories.CategoryRepository;
import com.rogeriofrsouza.course.repositories.OrderRepository;
import com.rogeriofrsouza.course.repositories.UserRepository;

@Configuration  // Classe específica de configuração
// @Profile("test")  // Perfil definido no application.properties
public class TestConfig implements CommandLineRunner {
	
	/*
	 * Injeção de dependência -> Deve ser fraca, desacoplada (SOLID)
	 * Framework possui um mecanismo de injeção implícito/automático
	 */
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Execução quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		// Database seeding -> instanciação do banco de dados
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
