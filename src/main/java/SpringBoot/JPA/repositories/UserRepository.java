package SpringBoot.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBoot.JPA.entities.User;

@Repository // É opcional porque ao extender o JpaRepository já esta a ser registada como um componente repository no springboot
public interface UserRepository extends JpaRepository<User,Long>{
	

}
