package com.spring.springApi.service.abstracts;

import java.util.List;

import com.spring.springApi.core.result.DataResult;
import com.spring.springApi.core.result.Result;
import com.spring.springApi.entity.ProductCategory;

public interface ProductCategoryService {
 
	Result add(ProductCategory productCategory);
	
	DataResult<List<ProductCategory>> getAll();
	
	Result updateProductCategory(ProductCategory productCategory);
	
	DataResult<ProductCategory> findByProductCategoryId(int id);
}
