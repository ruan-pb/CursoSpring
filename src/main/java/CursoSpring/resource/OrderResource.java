package CursoSpring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CursoSpring.entities.Order;
import CursoSpring.services.OrderService;

@RestController
@RequestMapping(value = "/orders")

public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		return new ResponseEntity<List<Order>>(orderService.findAll(),HttpStatus.OK); 
		//return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		return new ResponseEntity<Order>(orderService.findById(id),HttpStatus.OK);
	
	
	
	}

}
