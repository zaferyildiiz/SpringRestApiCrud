package com.spring.springApi.repository;

 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 

import com.spring.springApi.entity.Product; 

 
public interface ProductRepository extends JpaRepository<Product, Integer> {
 
	List<Product> getByProductNameContains(String name);
	
	List<Product> findAllByOrderByProductIdDesc();   

}
 