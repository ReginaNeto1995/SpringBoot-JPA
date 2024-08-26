package SpringBoot.JPA.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import SpringBoot.JPA.entities.User;
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

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Maria Brown","maria@gmail.com","9999999999","12345677");
		User u2 = new User(null, "John Due","john@outlook.pt","234568888","000000000");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
	
	
	
}
