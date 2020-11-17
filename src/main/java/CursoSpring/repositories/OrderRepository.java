package CursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CursoSpring.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
