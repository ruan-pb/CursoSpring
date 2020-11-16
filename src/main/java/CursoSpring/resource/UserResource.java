package CursoSpring.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CursoSpring.entities.User;

@RestController
@RequestMapping(value = "/user")

public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Ruan", "Ruancruzsoares@hotmail.com", "987442112", "flamengo");
		return new ResponseEntity<User> (u,HttpStatus.OK);
		//return ResponseEntity.ok().body(u);
	}
	
	
	

}
