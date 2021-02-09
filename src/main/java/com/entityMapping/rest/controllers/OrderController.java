package com.entityMapping.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entityMapping.rest.models.Order;
import com.entityMapping.rest.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository repository;
	
	public OrderController() {
		
	}
	
	@PostMapping
	public ResponseEntity create(@RequestBody Order order) {
		Order orderSaved = this.repository.save(order);
		return orderSaved.equals(null)
				? new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity(HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Order>> getAllProduct(){
		List<Order> result = this.repository.findAll();
		return result.equals(null)
				? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
				: new ResponseEntity<>(result, HttpStatus.OK);
	}
}
