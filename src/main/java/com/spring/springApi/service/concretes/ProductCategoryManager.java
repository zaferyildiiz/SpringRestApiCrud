package com.spring.springApi.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.core.result.SuccessDataResult;
import com.spring.springApi.core.result.SuccessResult;
import com.spring.springApi.entity.Product;
import com.spring.springApi.entity.ProductCategory;
import com.spring.springApi.repository.ProductCategoryRepository;
import com.spring.springApi.service.abstracts.ProductCategoryService;

@Service
public class ProductCategoryManager implements ProductCategoryService {

	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	public ProductCategoryManager(ProductCategoryRepository productCategoryRepository) {
		super();
		this.productCategoryRepository = productCategoryRepository;
	}

	@Override
	public Result add(ProductCategory productCategory) {
		this.productCategoryRepository.save(productCategory);
		return new SuccessResult("Kategori Eklendi");
	}

	@Override
	public DataResult<List<ProductCategory>> getAll() {
		return new SuccessDataResult<List<ProductCategory>>(this.productCategoryRepository.findAll(),
				"Data Listelendi");
	}

	@Override
	public Result updateProductCategory(ProductCategory productCategory) {
		ProductCategory category = productCategoryRepository
				.findByProductCategoryId(productCategory.getProductCategoryId());
		// crush the variables of the object found
		 category.setCategoryName(productCategory.getCategoryName());
		productCategoryRepository.save(category);
		
		return new SuccessResult("Kategori güncellendi");
	}

	@Override
	public DataResult<ProductCategory> findByProductCategoryId(int id) {
		return new SuccessDataResult<ProductCategory>(this.productCategoryRepository.findByProductCategoryId(id),
				"Data listelendi");
	}

}
