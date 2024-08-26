package SpringBoot.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.JPA.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	

}
