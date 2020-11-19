package CursoSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CursoSpring.entities.Category;
import CursoSpring.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")

public class CategoryResource {
	
	@Autowired
	private CategoryService CategoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		return new ResponseEntity<List<Category>>(CategoryService.findAll(),HttpStatus.OK); 
		//return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		return new ResponseEntity<Category>(CategoryService.findById(id),HttpStatus.OK);
	
	
	
	}

}
