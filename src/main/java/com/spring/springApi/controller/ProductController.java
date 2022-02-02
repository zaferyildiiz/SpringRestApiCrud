package com.spring.springApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.entity.Product;
import com.spring.springApi.service.abstracts.ProductService;

@RestController 
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	
	
	@Autowired 
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/getAllProduct")
	public DataResult<List<Product>> getAll(){
		 return this.productService.getAll();
	}
	
   @PostMapping("/addProduct")
   public Result add(@RequestBody Product product) {
	   return this.productService.add(product);
   }
	
   @PostMapping("/addProducts")
   public Result adds(@RequestBody List<Product> products) {
	   return this.productService.adds(products);
   } 
    
   
   @PutMapping("/updateProduct/{id}")
   public Result updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
	   return this.productService.updateProduct(id, product);
	   
   }
   
   @DeleteMapping("/deleteProduct/{id}") 
   public Result deleteProduct(int id)
   {
	   return this.productService.deleteProduct(id);
   }
   
   @GetMapping("/likeQuery/{name}")
   public DataResult<List<Product>> findByNameContaining(String name){
	   return this.productService.getByProductNameContains(name);
   }
   
   @GetMapping("/orderProduct")
   public DataResult<List<Product>> orderProduct(){
	   return this.productService.findAllByOrderByProductIdDesc();
   }
   
 
}
