package CursoSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CursoSpring.entities.User;
import CursoSpring.services.UserService;

@RestController
@RequestMapping(value = "/user")

public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.OK); 
		//return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return new ResponseEntity<User>(userService.findById(id),HttpStatus.OK);
	
	
	
	}
	@PostMapping
	public ResponseEntity<User>insert(@RequestBody User user){
		return new ResponseEntity<User>(userService.insert(user),HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		userService.delete(id);
		 return ResponseEntity.noContent().build();
	}
	

}
