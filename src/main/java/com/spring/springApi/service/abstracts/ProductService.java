package com.spring.springApi.service.abstracts;

import java.util.List;
 

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.entity.Product;

 
public interface ProductService {
	
	DataResult<List<Product>> getAll();  
 

	Result add(Product product);
	
	Result adds(List<Product> products);
	
	Result updateProduct(int id, Product product);
	
	Result deleteProduct(int id);
	
	DataResult<List<Product>> getByProductNameContains(String name);
	
	DataResult<List<Product>> findAllByOrderByProductIdDesc();

 
  
	
}
