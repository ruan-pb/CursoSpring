package CursoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CursoSpring.entities.User;
import CursoSpring.repositories.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userReposory;
	
	public List<User> findAll(){
		return userReposory.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userReposory.findById(id); 
		return user.get();
	}
	public User insert(User user) {
		return userReposory.save(user);
				
	}

}
