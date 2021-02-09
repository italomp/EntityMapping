package com.entityMapping.rest.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.entityMapping.rest.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAll();
}
