package SpringBoot.JPA.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBoot.JPA.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria","Maria@gmail.com","123456789","543452357");	
		return ResponseEntity.ok().body(u);
	}
	
	
	
	
	
	
}
