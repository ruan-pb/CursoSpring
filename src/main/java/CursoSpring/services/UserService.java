package CursoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import CursoSpring.entities.User;
import CursoSpring.repositories.UserRepository;
import CursoSpring.services.exceptions.DataBaseException;
import CursoSpring.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id); 
		return user.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	public User insert(User user) {
		return userRepository.save(user);
				
	}
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		
	}
	public User update(Long id, User user) {
		User entity = userRepository.getOne(id);
		updateData(entity,user);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}

}
