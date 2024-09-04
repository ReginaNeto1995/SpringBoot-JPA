package SpringBoot.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.JPA.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
