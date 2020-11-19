package CursoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CursoSpring.entities.Product;
import CursoSpring.repositories.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productReposory;
	
	public List<Product> findAll(){
		return productReposory.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> user = productReposory.findById(id); 
		return user.get();
	}

}
