package com.spring.springApi.entity;
 
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
import javax.persistence.Table; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Entity
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_quantity")
	private int quantity;
	
	@Column(name="product_price") 
	private double price;
 
 
	@ManyToOne() 
	@JoinColumn(name="product_category_id")    
	private ProductCategory productCategory; 
	 
  
}
