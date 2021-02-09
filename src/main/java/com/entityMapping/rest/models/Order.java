package com.entityMapping.rest.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Table(name = "TB_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany
	@JoinTable(name = "TB_ORDER_PRODUCT",
				joinColumns = @JoinColumn(name = "ORDER_ID"),
				inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private Set<Product> products;
	private Date moment;
	
	public Order() {
		this.products = new HashSet<>();
		this.moment = new Date(System.currentTimeMillis());
		
	}

	@Autowired
	public Order(Set<Product> products, Date moment) {
		this.products = products;
		this.moment = moment;
	}

	public Long getId() {
		return id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	
}
