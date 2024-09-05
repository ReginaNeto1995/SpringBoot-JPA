package SpringBoot.JPA.config;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import SpringBoot.JPA.entities.Category;
import SpringBoot.JPA.entities.Order;
import SpringBoot.JPA.entities.OrderItem;
import SpringBoot.JPA.entities.Product;
import SpringBoot.JPA.entities.User;
import SpringBoot.JPA.entities.enums.OrderStatus;
import SpringBoot.JPA.repositories.CategoryRepository;
import SpringBoot.JPA.repositories.OrderItemRepository;
import SpringBoot.JPA.repositories.OrderRepository;
import SpringBoot.JPA.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category (null,"Eletronics");
		Category cat2 = new Category (null,"Books");
		Category cat3 = new Category (null,"Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		User u1 = new User(null,"Maria Brown","maria@gmail.com","9999999999","12345677");
		User u2 = new User(null, "John Due","john@outlook.pt","234568888","000000000");	
		
		Order o1 = new Order(null, Instant.parse("2024-08-31T15:40:10Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null,Instant.parse("2024-08-28T12:40:10Z"),OrderStatus.WAITING_PAYMENT,u2);
		Order o3 = new Order(null, Instant.parse("2024-09-15T16:45:08Z"),OrderStatus.PAID,u1);

		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3,1,p4.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3,2,p1.getPrice());
		OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
	
	}
	
	
	
	
	
}
