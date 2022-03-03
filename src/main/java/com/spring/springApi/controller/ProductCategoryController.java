package com.spring.springApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result; 
import com.spring.springApi.core.result.SuccessResult;
import com.spring.springApi.entity.ProductCategory;
import com.spring.springApi.service.abstracts.ProductCategoryService;

@RestController
@RequestMapping("/productCategory")
@CrossOrigin
public class ProductCategoryController {
 
	private ProductCategoryService productCategoryService;
	
	@Autowired
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		super();
		this.productCategoryService=productCategoryService;
	}
	
	 @PostMapping("/addProductCategory")
	 public Result addProductCategory(@RequestBody ProductCategory productCategory) {
		 this.productCategoryService.add(productCategory);
		 return new SuccessResult("Kategori eklendi");
	 }
	 
	 
	 @GetMapping("/getAllProductCategories")
	 public DataResult<List<ProductCategory>> getAll() {
		return this.productCategoryService.getAll();
	 }
	 
	 @GetMapping("/getProductByProductId/{id}")
	 public DataResult<ProductCategory> getProductByProductId(int id){
		 return this.productCategoryService.findByProductCategoryId(id);
	 }
	 
	 @PutMapping("/updateProductCategory")
	 public Result updateProductCategory(@RequestBody ProductCategory productCategory)
	 {
		 return this.productCategoryService.updateProductCategory(productCategory);
	 }
	 
	  
}
