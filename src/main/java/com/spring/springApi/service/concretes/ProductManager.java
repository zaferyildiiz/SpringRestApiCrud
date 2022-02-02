package com.spring.springApi.service.concretes;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.core.result.SuccessDataResult;
import com.spring.springApi.core.result.SuccessResult;
import com.spring.springApi.entity.Product;
import com.spring.springApi.repository.ProductRepository;
import com.spring.springApi.service.abstracts.ProductService;

@Service
public class ProductManager implements ProductService {
	
 
private ProductRepository productRepository;
	
	@Autowired
	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>
		(this.productRepository.findAll(),"Data listelendi");	
	}

 

	@Override
	public Result add(Product product) {
		this.productRepository.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public Result adds(List<Product> products) {
		this.productRepository.saveAll(products);
		return new SuccessResult("Ürünler Eklendi");
	}


	
	@Override
	public Result updateProduct(int id,Product product)
	{ 
		Product productDetail = productRepository.findById(id).get();
		productDetail.setProductName(product.getProductName());
		productDetail.setPrice(product.getPrice());
		productDetail.setQuantity(product.getQuantity());
		productRepository.save(productDetail);
		return new SuccessResult("Ürün güncellendi.");
		
	}

	@Override
	public Result deleteProduct(int id) {
		 this.productRepository.deleteById(id);
		 return new SuccessResult("Ürün silindi.");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String name) {
	 return new SuccessDataResult<List<Product>>(
			 this.productRepository.getByProductNameContains(name),"Data Listelendi"
			 );
	}

	@Override
	public DataResult<List<Product>> findAllByOrderByProductIdDesc() {
		 return new SuccessDataResult<List<Product>>(
				 this.productRepository.findAllByOrderByProductIdDesc(),"Data Listelendi"
				 );
	}

 

  
 
 

 

	 
 
	 

 
	
 
 
}
