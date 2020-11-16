package CursoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import CursoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
