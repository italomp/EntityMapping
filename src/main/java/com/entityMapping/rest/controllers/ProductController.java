package com.entityMapping.rest.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entityMapping.rest.models.Product;
import com.entityMapping.rest.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository repository;

	public ProductController() {
		
	}
	
	@PostMapping
	public ResponseEntity create(@RequestBody Product product) {
		Product savedProduct = this.repository.save(product);
		return savedProduct.equals(null) 
				? new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> result = this.repository.findAll();
		return result.equals(null) 
				? new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(result, HttpStatus.OK);
	}
}
