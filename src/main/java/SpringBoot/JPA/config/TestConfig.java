package SpringBoot.JPA.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import SpringBoot.JPA.entities.Category;
import SpringBoot.JPA.entities.Order;
import SpringBoot.JPA.entities.User;
import SpringBoot.JPA.entities.enums.OrderStatus;
import SpringBoot.JPA.repositories.CategoryRepository;
import SpringBoot.JPA.repositories.OrderRepository;
import SpringBoot.JPA.repositories.UserRepository;

@Configuration
@Profile("test") //"test" Perfil de testes identificado no application.test.properties
public class TestConfig implements CommandLineRunner{

	/**
	 * Classe de configuração:é uma classe auxiliar que faz configurações na aplicação
	 * A classe TestConfig é uma classe especifica para a configuração do perfil de testes, vai servir para encher a base de dados com dados
	 * A classe de configuração vai ter que ter uma dependencia para o repository -> Dependencia tem que ser fraca , desacoplada
	 */
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category (null,"Eletronics");
		Category cat2 = new Category (null,"Books");
		Category cat3 = new Category (null,"Computers");
		
		User u1 = new User(null,"Maria Brown","maria@gmail.com","9999999999","12345677");
		User u2 = new User(null, "John Due","john@outlook.pt","234568888","000000000");	
		
		Order o1 = new Order(null, Instant.parse("2024-08-31T15:40:10Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null,Instant.parse("2024-08-28T12:40:10Z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2024-09-15T16:45:08Z"),OrderStatus.PAID,u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
	}
	
	
	
	
	
}
