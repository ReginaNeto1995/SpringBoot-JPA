package SpringBoot.JPA.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot.JPA.entities.User;
import SpringBoot.JPA.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//dependencia para o userService , o Autowired faz a injeção de dependencia
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();	
		return ResponseEntity.ok().body(list);
	}
	
	
	/**
	 * Endpoint para ir buscar o user pelo id, chama a camada de serviço que aplica regras de negócio e por sua vez chama o repositório para ir buscar à base de dados
	 * @param id identificador único do user
	 * @return User
	 */
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	
}
