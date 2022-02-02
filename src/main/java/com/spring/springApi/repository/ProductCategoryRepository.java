package com.spring.springApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springApi.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
   ProductCategory findByProductCategoryId(int id);
}
