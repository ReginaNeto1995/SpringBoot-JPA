package SpringBoot.JPA.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot.JPA.entities.OrderItem;
import SpringBoot.JPA.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
